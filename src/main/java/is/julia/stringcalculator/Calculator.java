package is.julia.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) return 0;
		if(text.contains("\n")) text = text.replace("\n", "");
		if(text.contains(",")) return split(text);


		return sum(text);
	}

	public static int sum(String text) {

		return parse(text);
	}


	public static int parse(String text) {
		return Integer.parseInt(text);	
	}

	public static int split(String text) {
		String[] parts = text.split(",");
		int result = 0;
		for(String p : parts) {
			result += parse(p);
		}

		return result;
	}
}
