import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Template {

    private Map<String, String> variables;

    private String templateText;

    public Template(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String name, String value) {
        this.variables.put(name, value);
    }

//    public String evaluate() {
//        String result = templateText;
//        for (Entry<String, String> entry: variables.entrySet()){
//        	String regex = "\\$\\{" + entry.getKey() + "\\}";
//        	result = result.replaceAll(regex, entry.getValue());
//        	
//        }
//        checkForMissingValues(result);
//        return result;
//    }
    
    // Change evaluate() according to chapter 3 listing 3.8
    public String evaluate() {
        TemplateParse parser = new TemplateParse();
        List<String> segments = parser.parse(templateText);
        return concatenate(segments);
        
    }
    
    private String concatenate(List<String> segments){
    	StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            append(segment, result);
        }
        return result.toString();
    }
    
    // refactor append method, according to Listing 3.9
//    private void append(String segment, StringBuilder result) {
//        if (segment.startsWith("${") && segment.endsWith("}")) {
//            String var = segment.substring(2, segment.length() - 1);
//            if (!variables.containsKey(var)) {
//                throw new MissingValueException("No value for " + segment);
//            }
//            result.append(variables.get(var));
//        } else {
//            result.append(segment);
//        }
//    }

    private void append ( String segment, StringBuilder result) {
    	if (isVariable(segment)){
    		evaluateVariable(segment, result);
    	}
    	else {
    		result.append(segment);
    	}
    }
    
   
	private boolean isVariable(String segment) {
		return segment.startsWith("${") && segment.endsWith("}");
	}
	
	private void evaluateVariable(String segment, StringBuilder result) {
		String var = segment.substring(2, segment.length() -1);
		if (!variables.containsKey(var)){
			throw new MissingValueException ("No value for " + segment);
		}
		result.append(variables.get(var));
	}

	private void checkForMissingValues (String result){
    	if (result.matches(".*\\$\\{.+\\}.*")){
    		throw new MissingValueException("missing value");
    	}
    }


}
