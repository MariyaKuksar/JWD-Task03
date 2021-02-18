package by.epam.task03.validator;

public class DataValidator {
public final static String STRING_DOUBLE_REGEX = "((\\-)?\\d+(\\.\\d+)?\\s){5}(\\-)?\\d+";

	public static boolean pointDataValidator(String lineData) {
			return lineData.matches(STRING_DOUBLE_REGEX);
	}
}
