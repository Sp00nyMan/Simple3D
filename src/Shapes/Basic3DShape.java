package Shapes;


import Shapes.BasicShape.BasicShape;

import java.awt.*;

public abstract class Basic3DShape
{
	BasicShape[] edges;
	protected final int pivotDiameter = 8;

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

		for (BasicShape edge : edges)
		{
			g.setColor(Color.ORANGE);
			edge.draw(g);
		}

		g.setColor(Color.BLUE);
		drawPivotPoints(g);
	}

	protected abstract void drawPivotPoints(Graphics2D g);
}
