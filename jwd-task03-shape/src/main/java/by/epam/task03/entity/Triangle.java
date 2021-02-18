package by.epam.task03.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task03.action.PointAction;
import by.epam.task03.exception.ShapeException;
import by.epam.task03.observer.CustomerObserver;
import by.epam.task03.observer.Observable;
import by.epam.task03.observer.TriangleEvent;
import by.epam.task03.validator.TriangleValidator;

public class Triangle extends CustomerShape implements Observable{
	public static Logger logger = LogManager.getLogger();
	public final static int NUMBER_VERTICES = 3;
	private CustomerPoint pointA;
	private CustomerPoint pointB;
	private CustomerPoint pointC;
	private List<CustomerObserver> observers = new ArrayList<>();

	public Triangle(CustomerPoint... points) throws ShapeException {
		super();
		if (points == null || points.length != NUMBER_VERTICES
				|| !(TriangleValidator.pointsFormShape(points[0], points[1], points[2]))) {
			throw new ShapeException(Arrays.toString(points) + " don't form triangle");
		}
		this.pointA = points[0];
		this.pointB = points[1];
		this.pointC = points[2];
	}

	public CustomerPoint getPointA() {
		return pointA;
	}

	public void setPointA(CustomerPoint pointA) throws ShapeException {
		if (!TriangleValidator.pointsFormShape(pointA, pointB, pointC)) {
			throw new ShapeException("points " + pointA + ", " + pointB + ", " + pointC + " don't form triangle");
		}
		this.pointA = pointA;
		notifyObservers();
	}

	public CustomerPoint getPointB() {
		return pointB;
	}

	public void setPointB(CustomerPoint pointB) throws ShapeException {
		if (!TriangleValidator.pointsFormShape(pointA, pointB, pointC)) {
			throw new ShapeException("points " + pointA + ", " + pointB + ", " + pointC + " don't form triangle");
		}
		this.pointB = pointB;
		notifyObservers();
	}

	public CustomerPoint getPointC() {
		return pointC;
	}

	public void setPointC(CustomerPoint pointC) throws ShapeException {
		if (!TriangleValidator.pointsFormShape(pointA, pointB, pointC)) {
			throw new ShapeException("points " + pointA + ", " + pointB + ", " + pointC + " don't form triangle");
		}
		this.pointC = pointC;
		notifyObservers();
	}

	public double findSideAB() {
		double sideAB;
		try {
			sideAB = PointAction.computeDistanceBetweenPoints(pointA, pointB);
		} catch (ShapeException e) {
			logger.log(Level.ERROR, "exception impossible", e);
			sideAB = 0;
		}
		BigDecimal bd = new BigDecimal(Double.toString(sideAB));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public double findSideBC() {
		double sideBC;
		try {
			sideBC = PointAction.computeDistanceBetweenPoints(pointB, pointC);
		} catch (ShapeException e) {
			logger.log(Level.ERROR, "exception impossible", e);
			sideBC = 0;
		}
		BigDecimal bd = new BigDecimal(Double.toString(sideBC));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public double findSideCA() {
		double sideCA;
		try {
			sideCA = PointAction.computeDistanceBetweenPoints(pointC, pointA);
		} catch (ShapeException e) {
			logger.log(Level.ERROR, "exception impossible", e);
			sideCA = 0;
		}
		BigDecimal bd = new BigDecimal(Double.toString(sideCA));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	@Override
	public void attach(CustomerObserver observer) {
		if (observer!=null) {
			observers.add(observer);
		}
	}

	@Override
	public void detach(CustomerObserver observer) {
		observers.remove(observer);		
	}

	@Override
	public void notifyObservers() {
		TriangleEvent event = new TriangleEvent(this);
		for (CustomerObserver observer : observers) {
			try {
				observer.parameterChanged(event);
			} catch (ShapeException e) {
				logger.log(Level.ERROR, "exception impossible");
			}
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointA == null) ? 0 : pointA.hashCode());
		result = prime * result + ((pointB == null) ? 0 : pointB.hashCode());
		result = prime * result + ((pointC == null) ? 0 : pointC.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (pointA == null) {
			if (other.pointA != null)
				return false;
		} else if (!pointA.equals(other.pointA))
			return false;
		if (pointB == null) {
			if (other.pointB != null)
				return false;
		} else if (!pointB.equals(other.pointB))
			return false;
		if (pointC == null) {
			if (other.pointC != null)
				return false;
		} else if (!pointC.equals(other.pointC))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("[pointA=");
		builder.append(pointA);
		builder.append(", pointB=");
		builder.append(pointB);
		builder.append(", pointC=");
		builder.append(pointC);
		builder.append("]");
		return builder.toString();
	}
}
