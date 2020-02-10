package Shapes;

import java.awt.*;
import java.awt.geom.Path2D;

import Math.*;

public class Triangle
{
	Vertex3 v1;
	Vertex3 v2;
	Vertex3 v3;
	Color color;

	public Triangle(Vertex3 v1, Vertex3 v2, Vertex3 v3, Color color)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.color = color;
	}

	public void draw(Graphics2D g, Matrix3 transform)
	{
		Triangle rotated = getRotated(transform);

		Path2D path = new Path2D.Double();

		path.moveTo(rotated.v1.getX(), rotated.v1.getY());
		path.lineTo(rotated.v2.getX(), rotated.v2.getY());
		path.lineTo(rotated.v3.getX(), rotated.v3.getY());
		path.closePath();

		g.draw(path);
	}

	public Triangle getRotated(Matrix3 transform)
	{
		Vertex3 v1 = transform.transform(this.v1);
		Vertex3 v2 = transform.transform(this.v2);
		Vertex3 v3 = transform.transform(this.v3);

		return new Triangle(v1, v2, v3, color);
	}
}
