package is.julia.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) return 0;
		if(text.contains("\n")) text = text.replace("\n", "");

		if(text.contains(",")) {
			String[] split = split(text);
			return sum(split);
		}

		int singleNum = parse(text);
		if(singleNum < 0)
			throw new IllegalArgumentException("Negatives not allowed: " + singleNum);
		else if (singleNum > 1000) 
			return 0;

		return singleNum;
	}

	public static int sum(String[] text) {
		int result = 0;
		for(String t : text) {
			int num = parse(t);
			if(num < 0) 
				minusNums(text);
			if(num > 1000)
				continue;
	
			result += num;
		}
		return result;
	}


	public static int parse(String text) {
		return Integer.parseInt(text);	
	}

	public static String[] split(String text) {
		String[] parts = text.split(",");

		return parts;
	}

	public static void minusNums(String[] text) {
		String errors = "";
		int counter = 0; 
		for(String t : text) {
			if(parse(t) < 0) {
				if(counter == 0) 
					errors += t;
				else
					errors += "," + t;
				counter++;
			}
		}

		throw new IllegalArgumentException("Negatives not allowed: " + errors);
	}
}
