package by.epam.task03.observer;

import by.epam.task03.exception.ShapeException;

public interface CustomerObserver {
	void parameterChanged (TriangleEvent event) throws ShapeException;
}
