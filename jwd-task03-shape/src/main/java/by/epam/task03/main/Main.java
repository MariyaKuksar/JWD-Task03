package by.epam.task03.main;

import java.util.List;

import by.epam.task03.action.impl.TriangleActionImpl;
import by.epam.task03.comporator.TriangleComparator;
import by.epam.task03.entity.CustomerPoint;
import by.epam.task03.entity.Triangle;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.factory.ShapeFactory;
import by.epam.task03.factory.TriangleFactory;
import by.epam.task03.observer.TriangleObserver;
import by.epam.task03.parser.CommonParser;
import by.epam.task03.parser.impl.DataParserImpl;
import by.epam.task03.reader.CommonReader;
import by.epam.task03.reader.impl.DataReaderImpl;
import by.epam.task03.repository.ShapeRepository;
import by.epam.task03.repository.Specification;
import by.epam.task03.repository.impl.AcuteAngledTriangleSpecification;
import by.epam.task03.repository.impl.AllPointsInFirstQuadrantSpecification;
import by.epam.task03.repository.impl.ObtuseTriangleSpecification;
import by.epam.task03.repository.impl.PerimeterIntervalSpecification;
import by.epam.task03.repository.impl.ShapeIdIntervalSpecification;
import by.epam.task03.repository.impl.SquareIntervalSpecification;
import by.epam.task03.warehouse.ShapeValue;
import by.epam.task03.warehouse.Warehouse;

public class Main {

	public static void main(String[] args) throws ShapeException {
		CommonReader reader = new DataReaderImpl();
		List<String> data = reader.readAll("resources/data/shape.txt");
		CommonParser parser = new DataParserImpl();
		List<CustomerPoint[]> triangleData = parser.parseList(data);
		ShapeFactory factory = new TriangleFactory();
		ShapeRepository repository = ShapeRepository.getShapeRepository();
		TriangleActionImpl triangleAction = new TriangleActionImpl();
		Warehouse warehouse = Warehouse.getWarehouse();
		for (CustomerPoint[] points : triangleData) {
			Triangle triangle = (Triangle) factory.createShape(points);
			repository.addShape(triangle);
			ShapeValue shapeValue = new ShapeValue(triangleAction.computePerimeter(triangle),
					triangleAction.computeSquare(triangle));
			warehouse.putShapeValue(triangle.getShapeId(), shapeValue);
		}

		Triangle triangle = (Triangle) repository.getShape(0);
		triangle.attach(new TriangleObserver());
		triangle.setPointA(new CustomerPoint(0, 0));
		triangle = (Triangle) repository.getShape(1);
		triangle.attach(new TriangleObserver());
		triangle.setPointC(new CustomerPoint(5, 0));

		Specification specification = new PerimeterIntervalSpecification(15, 20);
		repository.query(specification);
		specification = new SquareIntervalSpecification(0, 10);
		repository.query(specification);
		specification = new AllPointsInFirstQuadrantSpecification();
		repository.query(specification);
		specification = new AcuteAngledTriangleSpecification();
		repository.query(specification);
		specification = new ObtuseTriangleSpecification();
		repository.query(specification);
		specification = new ShapeIdIntervalSpecification(1, 3);
		repository.query(specification);

		repository.sort(TriangleComparator.PERIMETER);
		repository.sort(TriangleComparator.SQUARE);
		repository.sort(TriangleComparator.ID);
		repository.sort(TriangleComparator.POINT_A_X);
		repository.sort(TriangleComparator.POINT_A_Y);
	}
}
