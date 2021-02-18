package by.epam.task03.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;

public class TriangleFactory extends ShapeFactory {
	public static Logger logger = LogManager.getLogger();

	@Override
	public Triangle createShape(CustomerPoint... points) throws ShapeException {
		if (points == null || points.length!=Triangle.NUMBER_VERTICES) {
			throw new ShapeException("incorrect data for creating a triangle");
		}
		Triangle triangle = new Triangle(points);
		logger.log(Level.INFO, "shape created: " + triangle.toString());
		return triangle;
	}
}
