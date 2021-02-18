package by.epam.task03.util;

public class GeneratorId {
	private static long idCounter;

	private GeneratorId() {
	}

	public static long generateId() {
		return ++idCounter;
	}
}
