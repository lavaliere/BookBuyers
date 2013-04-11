package utils;

public class HTMLUtilities {

	
	public String htmlParser(String text){
		if(text.contains("'")){
			text.replaceAll("'", " &apos;");
		}
		
		return text;
	}
}
