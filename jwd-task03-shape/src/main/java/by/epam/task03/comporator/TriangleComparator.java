package by.epam.task03.comporator;

import java.util.Comparator;
import by.epam.task03.action.ShapeAction;
import by.epam.task03.action.impl.TriangleActionImpl;
import by.epam.task03.entity.CustomerShape;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;

public enum TriangleComparator implements Comparator<CustomerShape> {
	ID {
		@Override
		public int compare(CustomerShape shape1, CustomerShape shape2) {
			return Long.compare(shape1.getShapeId(), shape2.getShapeId());
		}
	},
	PERIMETER {
		@Override
		public int compare(CustomerShape shape1, CustomerShape shape2) {
			ShapeAction action = new TriangleActionImpl();
			int result;
			try {
				result = Double.compare(action.computePerimeter(shape1), action.computePerimeter(shape2));
			} catch (ShapeException e) {
				throw new NullPointerException();
			}
			return result;
		}
	},
	SQUARE {
		@Override
		public int compare(CustomerShape shape1, CustomerShape shape2) {
			ShapeAction action = new TriangleActionImpl();
			int result;
			try {
				result = Double.compare(action.computeSquare(shape1), action.computeSquare(shape2));
			} catch (ShapeException e) {
				throw new NullPointerException();
			}
			return result;
		}
	},
	POINT_A_X {
		@Override
		public int compare(CustomerShape shape1, CustomerShape shape2) {
			Triangle triangle1 = (Triangle) shape1;
			Triangle triangle2 = (Triangle) shape2;
			return Double.compare (triangle1.getPointA().getX(),triangle2.getPointA().getX());
		}
	},
	POINT_A_Y {
		@Override
		public int compare(CustomerShape shape1, CustomerShape shape2) {
			Triangle triangle1 = (Triangle) shape1;
			Triangle triangle2 = (Triangle) shape2;
			return Double.compare (triangle1.getPointA().getY(),triangle2.getPointA().getY());
		}
	}
}