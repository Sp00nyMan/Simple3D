package Shapes;
import Math.*;

import java.awt.*;
import java.awt.geom.Path2D;

public class Rect
{
	Vertex3 v1;
	Vertex3 v2;
	Vertex3 v3;
	Vertex3 v4;
	Color color;

	public Rect(Vertex3 v1, Vertex3 v2, Vertex3 v3, Vertex3 v4, Color color)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;

		this.color = color;
	}

	public void draw(Graphics2D g, Matrix3 transform)
	{
		Path2D.Double path = new Path2D.Double();
		Rect rotated = getRotated(transform);
		path.moveTo(rotated.v1.getX(), rotated.v1.getY());
		path.lineTo(rotated.v2.getX(), rotated.v2.getY());
		path.lineTo(rotated.v3.getX(), rotated.v3.getY());
		path.lineTo(rotated.v4.getX(), rotated.v4.getY());
		path.closePath();
		g.draw(path);
	}

	public Rect getRotated(Matrix3 transform)
	{
		Vertex3 v1 = transform.transform(this.v1);
		Vertex3 v2 = transform.transform(this.v2);
		Vertex3 v3 = transform.transform(this.v3);
		Vertex3 v4 = transform.transform(this.v4);

		return new Rect(v1, v2, v3, v4, color);
	}
}
