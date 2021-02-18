package by.epam.task03.action;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.exception.ShapeException;

public class PointAction {

	public static double computeDistanceBetweenPoints(CustomerPoint pointA, CustomerPoint pointB)
			throws ShapeException {
		if (pointA == null || pointB == null) {
			throw new ShapeException("point is null");
		}
		double distanceBetweenPoints = Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2)
				+ Math.pow(pointB.getY() - pointA.getY(), 2));
		return distanceBetweenPoints;
	}
}
