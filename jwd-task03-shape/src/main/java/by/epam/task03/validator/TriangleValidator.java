package by.epam.task03.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.Triangle;

public class TriangleValidator {

	public static boolean pointsFormShape(CustomerPoint pointA, CustomerPoint pointB, CustomerPoint pointC) {
		if (pointA == null || pointB == null || pointC == null) {
			return false;
		}
		boolean result = (pointC.getY() - pointA.getY())
				* (pointB.getX() - pointA.getX()) != (pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY());
		return result;
	}

	public static boolean isRightTriangle(Triangle triangle) {
		if (triangle == null) {
			return false;
		}
		List<Double> sidesTriangle = new ArrayList<Double>();
		sidesTriangle.add(triangle.findSideAB());
		sidesTriangle.add(triangle.findSideBC());
		sidesTriangle.add(triangle.findSideCA());
		double maxSide = Collections.max(sidesTriangle);
		sidesTriangle.remove(maxSide);
		boolean result = Math.pow(maxSide, 2) == Math.pow(sidesTriangle.get(0), 2) + Math.pow(sidesTriangle.get(1), 2);
		return result;
	}

	public static boolean isIsoscelesTriangle(Triangle triangle) {
		if (triangle == null) {
			return false;
		}
		double sideAB = triangle.findSideAB();
		double sideBC = triangle.findSideBC();
		double sideCA = triangle.findSideCA();
		return (sideAB == sideBC || sideBC == sideCA || sideCA == sideAB);
	}

	public static boolean isEquilateralTriangle(Triangle triangle) {
		if (triangle == null) {
			return false;
		}
		double sideAB = triangle.findSideAB();
		double sideBC = triangle.findSideBC();
		double sideCA = triangle.findSideCA();
		return (sideAB == sideBC && sideBC == sideCA);
	}

	public static boolean isAcuteAngledTriangle(Triangle triangle) {
		if (triangle == null) {
			return false;
		}
		List<Double> sidesTriangle = new ArrayList<Double>();
		sidesTriangle.add(triangle.findSideAB());
		sidesTriangle.add(triangle.findSideBC());
		sidesTriangle.add(triangle.findSideCA());
		double maxSide = Collections.max(sidesTriangle);
		sidesTriangle.remove(maxSide);
		boolean result = Math.pow(maxSide, 2) < Math.pow(sidesTriangle.get(0), 2) + Math.pow(sidesTriangle.get(1), 2);
		return result;
	}

	public static boolean isObtuseTriangle(Triangle triangle) {
		if (triangle == null) {
			return false;
		}
		List<Double> sidesTriangle = new ArrayList<Double>();
		sidesTriangle.add(triangle.findSideAB());
		sidesTriangle.add(triangle.findSideBC());
		sidesTriangle.add(triangle.findSideCA());
		double maxSide = Collections.max(sidesTriangle);
		sidesTriangle.remove(maxSide);
		boolean result = Math.pow(maxSide, 2) > Math.pow(sidesTriangle.get(0), 2) + Math.pow(sidesTriangle.get(1), 2);
		return result;
	}
}
