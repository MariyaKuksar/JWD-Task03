package by.epam.task03.repository.impl;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.CustomerShape;
import by.epam.task03.entity.Triangle;
import by.epam.task03.repository.Specification;

public class AllPointsInFirstQuadrantSpecification implements Specification {

	@Override
	public boolean specify(CustomerShape shape) {
		if (shape == null || shape.getClass() != Triangle.class) {
			return false;
		}
		Triangle triangle = (Triangle) shape;
		boolean result;
		CustomerPoint pointA = triangle.getPointA();
		CustomerPoint pointB = triangle.getPointB();
		CustomerPoint pointC = triangle.getPointC();
		result = pointA.getX() > 0 && pointA.getY() > 0 && pointB.getX() > 0 && pointB.getY() > 0 && pointC.getX() > 0
				&& pointC.getY() > 0;
		return result;
	}
}
