package by.epam.task03.validator.impl;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.validator.TriangleValidator;

public class TriangleValidatorImplTest {
	CustomerPoint pointA;
	CustomerPoint pointB;
	CustomerPoint pointC;
	Triangle triangle;

	@Test
	public void pointsFormShapeTest01() {
		pointA = new CustomerPoint(2, 1);
		pointB = new CustomerPoint(-3, 1);
		pointC = new CustomerPoint(0.8, 1);
		Assert.assertFalse(TriangleValidator.pointsFormShape(pointA, pointB, pointC));
	}

	@Test
	public void pointsFormShapeTest02() {
		pointA = new CustomerPoint(2, 1);
		pointB = null;
		pointC = new CustomerPoint(0.8, 1);
		Assert.assertFalse(TriangleValidator.pointsFormShape(pointA, pointB, pointC));
	}

	@Test
	public void pointsFormShapeTest03() {
		pointA = new CustomerPoint(1.5, -3);
		pointB = new CustomerPoint(6, 9);
		pointC = new CustomerPoint(2, 7);
		Assert.assertTrue(TriangleValidator.pointsFormShape(pointA, pointB, pointC));
	}

	@Test
	public void isRightTriangleTest01() throws ShapeException {
		pointA = new CustomerPoint(3, 10);
		pointB = new CustomerPoint(3, 2);
		pointC = new CustomerPoint(9, 2);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertTrue(TriangleValidator.isRightTriangle(triangle));
	}

	@Test
	public void isRightTriangleTest02() throws ShapeException {
		pointA = new CustomerPoint(3, 10);
		pointB = new CustomerPoint(1, 5);
		pointC = new CustomerPoint(9, 2);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertFalse(TriangleValidator.isRightTriangle(triangle));
	}

	@Test
	public void isRightTriangleTest03() throws ShapeException {
		Assert.assertFalse(TriangleValidator.isRightTriangle(null));
	}

	@Test
	public void isIsoscelesTriangleTest01() throws ShapeException {
		pointA = new CustomerPoint(3, 2);
		pointB = new CustomerPoint(0, 10);
		pointC = new CustomerPoint(-3, 2);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertTrue(TriangleValidator.isIsoscelesTriangle(triangle));
	}

	@Test
	public void isIsoscelesTriangleTest02() throws ShapeException {
		pointA = new CustomerPoint(3, 2);
		pointB = new CustomerPoint(0, 10);
		pointC = new CustomerPoint(-5, 2);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertFalse(TriangleValidator.isIsoscelesTriangle(triangle));
	}

	@Test
	public void isIsoscelesTriangleTest03() throws ShapeException {
		Assert.assertFalse(TriangleValidator.isIsoscelesTriangle(null));
	}

	@Test
	public void isEquilateralTriangleTest01() throws ShapeException {
		pointA = new CustomerPoint(0, 0);
		pointB = new CustomerPoint(0.5, 0.866);
		pointC = new CustomerPoint(1, 0);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertTrue(TriangleValidator.isEquilateralTriangle(triangle));
	}

	@Test
	public void isEquilateralTriangleTest02() throws ShapeException {
		pointA = new CustomerPoint(5, 0);
		pointB = new CustomerPoint(0, 10);
		pointC = new CustomerPoint(-5, 0);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertFalse(TriangleValidator.isEquilateralTriangle(triangle));
	}

	@Test
	public void isEquilateralTriangleTest03() throws ShapeException {
		Assert.assertFalse(TriangleValidator.isEquilateralTriangle(null));
	}
	
	@Test
	public void isAcuteAngledTriangleTest01() throws ShapeException {
		pointA = new CustomerPoint(7, 0);
		pointB = new CustomerPoint(-4, 0);
		pointC = new CustomerPoint(-1, 10);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertTrue(TriangleValidator.isAcuteAngledTriangle(triangle));
	}

	@Test
	public void isAcuteAngledTriangleTest02() throws ShapeException {
		pointA = new CustomerPoint(0, 7);
		pointB = new CustomerPoint(-4, 0);
		pointC = new CustomerPoint(-4, 10);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertFalse(TriangleValidator.isAcuteAngledTriangle(triangle));
	}

	@Test
	public void isAcuteAngledTriangleTest03() throws ShapeException {
		Assert.assertFalse(TriangleValidator.isAcuteAngledTriangle(null));
	}
	
	@Test
	public void isObtuseTriangleTest01() throws ShapeException {
		pointA = new CustomerPoint(4, 0);
		pointB = new CustomerPoint(8, 9);
		pointC = new CustomerPoint(-3, 0);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertTrue(TriangleValidator.isObtuseTriangle(triangle));
	}

	@Test
	public void isObtuseTriangleTest02() throws ShapeException {
		pointA = new CustomerPoint(7, 0);
		pointB = new CustomerPoint(-10, 0);
		pointC = new CustomerPoint(-4, 10);
		triangle = new Triangle(pointA, pointB, pointC);
		Assert.assertFalse(TriangleValidator.isObtuseTriangle(triangle));
	}

	@Test
	public void isObtuseTriangleTest03() throws ShapeException {
		Assert.assertFalse(TriangleValidator.isObtuseTriangle(null));
	}
}
