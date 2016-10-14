package is.julia.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) return 0;


		return sum(text);
	}

	public static int sum(String text) {

		return parse(text);
	}


	public static int parse(String text) {
		return Integer.parseInt(text);	
	}
}
