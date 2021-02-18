package by.epam.task03.entity;

import by.epam.task03.util.GeneratorId;

public abstract class CustomerShape {
	private long shapeId;

	public CustomerShape() {
		this.shapeId = GeneratorId.generateId();
	}

	public long getShapeId() {
		return shapeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append(" [shapeId=");
		builder.append(shapeId);
		builder.append("]");
		return builder.toString();
	}
}
