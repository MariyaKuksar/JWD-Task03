package by.epam.task03.action.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task03.action.ShapeAction;
import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.CustomerShape;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;

public class TriangleActionImpl implements ShapeAction {
	public static Logger logger = LogManager.getLogger();

	public double computePerimeter(CustomerShape shape) throws ShapeException {
		if (shape == null || shape.getClass() != Triangle.class) {
			throw new ShapeException("Incompatible shape");
		}
		Triangle triangle = (Triangle) shape;
		double perimeter = triangle.findSideAB() + triangle.findSideBC() + triangle.findSideCA();
		logger.log(Level.INFO, "perimeter triangle " + triangle.toString() + " :" + perimeter);
		return perimeter;
	}

	@Override
	public double computeSquare(CustomerShape shape) throws ShapeException {
		if (shape == null || shape.getClass() != Triangle.class) {
			throw new ShapeException("Incompatible shape");
		}
		Triangle triangle = (Triangle) shape;
		CustomerPoint pointA = triangle.getPointA();
		CustomerPoint pointB = triangle.getPointB();
		CustomerPoint pointC = triangle.getPointC();
		double square = 0.5 * Math.abs((pointB.getX() - pointA.getX()) * (pointC.getY() - pointA.getY())
				- (pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY()));
		logger.log(Level.INFO, "square triangle " + shape.toString() + " :" + square);
		return square;
	}
}