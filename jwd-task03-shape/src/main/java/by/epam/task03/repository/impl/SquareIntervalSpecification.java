package by.epam.task03.repository.impl;

import by.epam.task03.action.ShapeAction;
import by.epam.task03.action.impl.TriangleActionImpl;
import by.epam.task03.entity.CustomerShape;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.repository.Specification;

public class SquareIntervalSpecification implements Specification {
	private ShapeAction shapeAction;
	private double squareFrom;
	private double squareTo;

	public SquareIntervalSpecification(double squareFrom, double squareTo) {
		this.squareFrom = squareFrom;
		this.squareTo = squareTo;
		shapeAction = new TriangleActionImpl();
	}

	@Override
	public boolean specify(CustomerShape shape) {
		boolean result;
		try {
			double square = shapeAction.computeSquare(shape);
			result = square >= squareFrom && square <= squareTo;
		} catch (ShapeException e) {
			result = false;
		}
		return result;
	}
}
