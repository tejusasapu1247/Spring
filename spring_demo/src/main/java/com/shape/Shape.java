package com.shape;

import java.util.List;

public class Shape {
private List<Point> points;

public List<Point> getPoints() {
	return points;
}

public void setPoints(List<Point> points) {
	this.points = points;
}
public void printPointDetails() {
     System.out.println("----------points details--------");
    points.forEach(a-> System.out.println(a));

}
}
