package by.epam.task03.repository.impl;

import by.epam.task03.action.ShapeAction;
import by.epam.task03.action.impl.TriangleActionImpl;
import by.epam.task03.entity.CustomerShape;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.repository.Specification;

public class PerimeterIntervalSpecification implements Specification {
	private ShapeAction shapeAction;
	private double perimeterFrom;
	private double perimeterTo;

	public PerimeterIntervalSpecification(double perimeterFrom, double perimeterTo) {
		this.perimeterFrom = perimeterFrom;
		this.perimeterTo = perimeterTo;
		shapeAction = new TriangleActionImpl();
	}

	@Override
	public boolean specify(CustomerShape shape) {
		boolean result;
		try {
			double perimeter = shapeAction.computePerimeter(shape);
			result = perimeter >= perimeterFrom && perimeter <= perimeterTo;
		} catch (ShapeException e) {
			result = false;
		}
		return result;
	}
}
