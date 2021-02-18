package by.epam.task03.reader;

import java.util.List;

import by.epam.task03.exception.ShapeException;

public interface CommonReader {
	List<String> readAll(String path) throws ShapeException;
}
