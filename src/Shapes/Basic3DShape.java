package Shapes;


import Shapes.BasicShape.BasicShape;

import java.awt.*;

public abstract class Basic3DShape
{
	BasicShape[] edges;
	protected final int pivotDiameter = 8;
	protected final int pivotOffset = 4;

	public void rotate(double xAngle, double yAngle, double zAngle)
	{
		for (BasicShape edge : edges)
		{
			edge.rotate(xAngle, yAngle, zAngle);
		}
	}
	public void draw(Graphics2D g)
	{
		g.setStroke(new BasicStroke(3));

		g.setColor(Color.ORANGE);
		for (BasicShape edge : edges)
		{
			edge.draw(g);
		}

		g.setColor(Color.BLUE);
		drawPivotPoints(g);
	}

	protected abstract void drawPivotPoints(Graphics2D g);
}
