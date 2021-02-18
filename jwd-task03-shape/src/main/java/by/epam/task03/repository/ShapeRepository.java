package by.epam.task03.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task03.entity.CustomerShape;
import by.epam.task03.exception.ShapeException;


public class ShapeRepository {
	public static Logger logger = LogManager.getLogger();
	private final static ShapeRepository repository = new ShapeRepository();
	private List<CustomerShape> shapes = new ArrayList<>();

	private ShapeRepository() {
	}

	public static ShapeRepository getShapeRepository () {
		return repository;
	}
	
	public boolean addShape(CustomerShape shape) throws ShapeException {
		if (shape == null) {
			throw new ShapeException("shape repository cannot store null");
		}
		return shapes.add(shape);
	}

	public boolean removeShape(CustomerShape shape) {
		return this.shapes.remove(shape);
	}

	public CustomerShape setShape(int index, CustomerShape shape) throws ShapeException {
		if (shape == null) {
			throw new ShapeException("shape repository cannot store null");
		}
		return shapes.set(index, shape);
	}

	public CustomerShape getShape(int index) {
		return shapes.get(index);
	}

	public List<CustomerShape> query(Specification specification) {
		List<CustomerShape> requestedShapes = new ArrayList<CustomerShape>();
		for (CustomerShape shape : shapes) {
			if (specification.specify(shape)) {
				requestedShapes.add(shape);
			}
		}
		logger.log(Level.INFO, "requested shapes: " + requestedShapes.toString());
		return requestedShapes;
	}

	public List<CustomerShape> sort(Comparator<CustomerShape> comparator) {
		shapes.sort(comparator);
		logger.log(Level.INFO, "sorted shapes: " + shapes.toString());
		return shapes;
	}
}
