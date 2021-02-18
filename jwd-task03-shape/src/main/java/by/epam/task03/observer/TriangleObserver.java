package by.epam.task03.observer;

import by.epam.task03.action.ShapeAction;
import by.epam.task03.action.impl.TriangleActionImpl;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.warehouse.ShapeValue;
import by.epam.task03.warehouse.Warehouse;

public class TriangleObserver implements CustomerObserver {

	@Override
	public void parameterChanged(TriangleEvent event) throws ShapeException {
		if (event == null) {
			throw new ShapeException("argument is null");
		}
		Triangle triangle = event.getSource();
		ShapeAction action = new TriangleActionImpl();
		double perimeter = action.computePerimeter(triangle);
		double square = action.computeSquare(triangle);
		ShapeValue shapeValue = new ShapeValue(perimeter, square);
		Warehouse warehouse = Warehouse.getWarehouse();
		warehouse.putShapeValue(triangle.getShapeId(), shapeValue);		
	}
}
