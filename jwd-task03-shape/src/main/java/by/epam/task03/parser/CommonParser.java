package by.epam.task03.parser;

import java.util.List;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.exception.ShapeException;

public interface CommonParser {

	List<CustomerPoint[]> parseList(List<String> data) throws ShapeException;

	CustomerPoint[] parseLine(String lineData) throws ShapeException;
}
