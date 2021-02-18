package by.epam.task03.action.impl;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;

public class TriangleActionTest {
	TriangleActionImpl action;
	CustomerPoint pointA;
	CustomerPoint pointB;
	CustomerPoint pointC;
	Triangle triangle;

	@BeforeClass
	public void setUp() {
		action = new TriangleActionImpl();
	}

	@Test
	public void computePerimeterTest01() throws ShapeException {
		pointA = new CustomerPoint(2, -5);
		pointB = new CustomerPoint(-6, 1);
		pointC = new CustomerPoint(6, -2);
		triangle = new Triangle(pointA, pointB, pointC);
		double expected = 27.4;
		double actual = action.computePerimeter(triangle);
		Assert.assertEquals(actual, expected, 0.1);
	}

	@Test(expectedExceptions = ShapeException.class)
	public void computePerimeterExceptionTest() throws ShapeException {
		action.computePerimeter(null);
	}

	@Test
	public void computeSquareTest01() throws ShapeException {
		pointA = new CustomerPoint(2, -5);
		pointB = new CustomerPoint(-6, 1);
		pointC = new CustomerPoint(6, -2);
		triangle = new Triangle(pointA, pointB, pointC);
		double expected = 24;
		double actual = action.computeSquare(triangle);
		Assert.assertEquals(actual, expected, 0.1);
	}

	@Test(expectedExceptions = ShapeException.class)
	public void computeSquareExceptionTest() throws ShapeException {
		action.computeSquare(null);
	}

	@AfterClass
	public void tierDown() {
		action = null;
	}
}
