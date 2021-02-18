package by.epam.task03.repository.impl;

import by.epam.task03.entity.CustomerShape;
import by.epam.task03.repository.Specification;

public class ShapeIdIntervalSpecification implements Specification {
	private double shapeIdFrom;
	private double shapeIdTo;

	public ShapeIdIntervalSpecification(double shapeIdFrom, double shapeIdTo) {
		this.shapeIdFrom = shapeIdFrom;
		this.shapeIdTo = shapeIdTo;
	}

	@Override
	public boolean specify(CustomerShape shape) {
		boolean result = shape.getShapeId() >= shapeIdFrom && shape.getShapeId() <= shapeIdTo;
		return result;
	}

}
