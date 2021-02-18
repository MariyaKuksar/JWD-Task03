package by.epam.task03.repository.impl;

import by.epam.task03.entity.CustomerShape;
import by.epam.task03.entity.Triangle;
import by.epam.task03.repository.Specification;
import by.epam.task03.validator.TriangleValidator;

public class AcuteAngledTriangleSpecification implements Specification {

	@Override
	public boolean specify(CustomerShape shape) {
		if (shape == null || shape.getClass() != Triangle.class) {
			return false;
		}
		Triangle triangle = (Triangle) shape;
		boolean result = TriangleValidator.isAcuteAngledTriangle(triangle);
		return result;
	}
}
