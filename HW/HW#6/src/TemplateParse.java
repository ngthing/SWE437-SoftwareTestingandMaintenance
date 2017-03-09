// Code from Koskela's Listing 3.6 
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse {
 
    public List<String> parse(String template) {
        List<String> segments = new ArrayList<String>();
        int index = collectSegments(segments,template);
        addTail(segments, template, index);
        return segments;
    }

    private int collectSegments(List<String> segs, String src) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(src);
        int index = 0;
        while (matcher.find()) {
            addPrecedingPlainText(segs, src, matcher, index);
            addVariable(segs, src, matcher);
            index = matcher.end();
        }
        return index;
    }

    private void addTail(List<String> segs, String src, int index) {
        if (index < src.length())
            segs.add(src.substring(index));
    }

    private void addVariable(List<String> segs, String src, Matcher m) {
        segs.add(src.substring(m.start(), m.end()));
    }

    private void addPrecedingPlainText(List<String> segs, String src,
            Matcher matcher, int index) {
        if (index != matcher.start()) {
            segs.add(src.substring(index, matcher.start()));
        }
    }
    
    private void addEmptyStringIfTemplateWasEmpty(List<String> segs){
    	if (segs.isEmpty()){
    		segs.add("");
    	}
    }

}
