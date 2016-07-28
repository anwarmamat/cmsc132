

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {

	public static String getInput(String prompt) {
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));

		System.out.print(prompt);
		System.out.flush();
		try {
			return stdin.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
	public static double getDoubleInput(String prompt) 
                throws NumberFormatException {

		String input = getInput(prompt);
		return Double.parseDouble(input);

	}
        public static String getStringInput(String prompt) 
                throws NumberFormatException {

		String input = getInput(prompt);
		return input;

	}
        public static Integer getIntegerInput(String prompt) 
                throws NumberFormatException {

		String input = getInput(prompt);
		return Integer.parseInt(input);
	}
}
