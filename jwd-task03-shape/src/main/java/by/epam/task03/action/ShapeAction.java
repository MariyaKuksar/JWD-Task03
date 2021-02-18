package by.epam.task03.action;

import by.epam.task03.entity.CustomerShape;
import by.epam.task03.exception.ShapeException;

public interface ShapeAction {
	double computePerimeter(CustomerShape shape) throws ShapeException;
	
	double computeSquare(CustomerShape shape) throws ShapeException;
}
