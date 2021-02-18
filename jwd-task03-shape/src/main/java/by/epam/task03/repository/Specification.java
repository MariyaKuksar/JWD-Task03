package by.epam.task03.repository;

import by.epam.task03.entity.CustomerShape;

public interface Specification {
	boolean specify(CustomerShape shape);
}
