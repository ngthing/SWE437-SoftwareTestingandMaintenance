import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class TestTemplateParse {
	private List<String> parse(String template) {
	    return new TemplateParse().parse(template);
	}
	private void assertSegments(List<? extends Object> actual,
            Object... expected) {
        assertEquals("Number of segments doesn't match.",
                expected.length, actual.size());
        assertEquals(Arrays.asList(expected), actual);
    }
	@Test
	public void emptyTemplateRendersAsEmptyString() throws Exception {
	    List<String> segments = parse("");
	    assertEquals("Number of segments", 1, segments.size());
	    assertEquals("", segments.get(0));
	}

	@Test
	public void templateWithOnlyPlainText() throws Exception {
	    List<String> segments = parse("plain text only");
	    assertEquals("Number of segments", 1, segments.size());
	    assertEquals("plain text only", segments.get(0));
	}
	@Test
	public void parsingMultipleVariables() throws Exception {
	    List<String> segments = parse("${a}:${b}:${c}");
	    assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
	}




}
