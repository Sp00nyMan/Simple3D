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

	public void draw(Graphics2D g)
	{
		Path2D.Double path = new Path2D.Double();
		path.moveTo(v1.getX(), v1.getY());
		path.lineTo(v2.getX(), v2.getY());
		path.lineTo(v3.getX(), v3.getY());
		path.lineTo(v4.getX(), v4.getY());
		path.closePath();
		g.draw(path);
	}

	public void rotate(Matrix3 transform)
	{
		v1 = transform.transform(v1);
		v2 = transform.transform(v2);
		v3 = transform.transform(v3);
		v4 = transform.transform(v4);
	}
}
