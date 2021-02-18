package by.epam.task03.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.parser.CommonParser;
import by.epam.task03.validator.DataValidator;
import by.epam.task03.validator.TriangleValidator;

public class DataParserImpl implements CommonParser {
	public static Logger logger = LogManager.getLogger();
	public final static String NUMBER_SPLIT = " ";

	@Override
	public List<CustomerPoint[]> parseList(List<String> data) throws ShapeException {
		if (data == null || data.isEmpty()) {
			throw new ShapeException("argument is null or empty");
		}
		List<CustomerPoint[]> triangleData = new ArrayList<CustomerPoint[]>();
		CustomerPoint[] points;
		for (String lineData : data) {
			try {
				points = parseLine(lineData);
				triangleData.add(points);
			} catch (ShapeException e) {
				logger.log(Level.ERROR, lineData + " is not suitable for creating a triangle");
			}
		}
		if (triangleData.isEmpty()) {
			throw new ShapeException("no data to create a triangle");
		}
		return triangleData;
	}

	@Override
	public CustomerPoint[] parseLine(String lineData) throws ShapeException {
		if (!DataValidator.pointDataValidator(lineData)) {
			throw new ShapeException(lineData + " is not suitable for creating a triangle");
		}
		String[] linePointCoordinate = lineData.split(NUMBER_SPLIT);
		CustomerPoint[] points = new CustomerPoint[Triangle.NUMBER_VERTICES];
		int numberPoint = 0;
		int numberCoordinate = 0;
		while (numberPoint < points.length) {
			points[numberPoint] = new CustomerPoint(Double.parseDouble(linePointCoordinate[numberCoordinate]),
					Double.parseDouble(linePointCoordinate[numberCoordinate + 1]));
			numberPoint++;
			numberCoordinate = numberCoordinate + 2;
		}
		if (!TriangleValidator.pointsFormShape(points[0], points[1], points[2])) {
			throw new ShapeException(Arrays.toString(points) + " don't form triangle");
		}
		return points;
	}
}
