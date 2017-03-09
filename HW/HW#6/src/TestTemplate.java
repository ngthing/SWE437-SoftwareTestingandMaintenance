import static org.junit.Assert.*;
import org.junit.*;


public class TestTemplate {

    private Template template;

    @Before
    public void setUp() {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multiplePlaceholders() throws Exception {
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        template.set("doesnotexist", "Hi");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void settingValueMultipleTimes() {
        template.set("three", "4");
        assertTemplateEvaluatesTo("1, 2, 4");
    }
    	
    private void assertTemplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }
    @Test
    public void missingValueRaisesException() throws Exception {
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() should throw an exception if "
                    + "a variable was left without a value!");
        } catch (MissingValueException expected) {
        }
    }

}
