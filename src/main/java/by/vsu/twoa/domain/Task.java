package by.vsu.twoa.domain;

import by.vsu.twoa.geometry.Circle;
import by.vsu.twoa.geometry.Point;
import by.vsu.twoa.geometry.Rectangle;

import java.util.Date;

public class Task extends Entity {
	private User owner;
	private String name;
	private Date created;
	private Point vertex1;
	private Point vertex2;
	private Double radius;
	private Rectangle rectangleVariant1;
	private Circle circumCircleVariant1;
	private Rectangle rectangleVariant2;
	private Circle circumCircleVariant2;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Point getVertex1() {
		return vertex1;
	}

	public void setVertex1(Point vertex1) {
		this.vertex1 = vertex1;
	}

	public Point getVertex2() {
		return vertex2;
	}

	public void setVertex2(Point vertex2) {
		this.vertex2 = vertex2;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Rectangle getRectangleVariant1() {
		return rectangleVariant1;
	}

	public void setRectangleVariant1(Rectangle rectangleVariant1) {
		this.rectangleVariant1 = rectangleVariant1;
	}

	public Circle getCircumCircleVariant1() {
		return circumCircleVariant1;
	}

	public void setCircumCircleVariant1(Circle circumCircleVariant1) {
		this.circumCircleVariant1 = circumCircleVariant1;
	}

	public Rectangle getRectangleVariant2() {
		return rectangleVariant2;
	}

	public void setRectangleVariant2(Rectangle rectangleVariant2) {
		this.rectangleVariant2 = rectangleVariant2;
	}

	public Circle getCircumCircleVariant2() {
		return circumCircleVariant2;
	}

	public void setCircumCircleVariant2(Circle circumCircleVariant2) {
		this.circumCircleVariant2 = circumCircleVariant2;
	}
}
