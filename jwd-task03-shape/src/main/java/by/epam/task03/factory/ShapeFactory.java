package by.epam.task03.factory;

import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.CustomerShape;
import by.epam.task03.exception.ShapeException;

public abstract class ShapeFactory {

	public abstract CustomerShape createShape (CustomerPoint... points) throws ShapeException;
}