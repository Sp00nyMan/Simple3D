package Shapes;

import Shapes.BasicShape.Triangle;

import java.awt.*;
import Math.Vertex3;

public class Icosahedron extends Basic3DShape
{
	public Icosahedron()
	{
		this.edges = new Triangle[5];
		double Radius = 100;
		double angleB = Math.toRadians(180/5);
		double angleA = Math.toRadians(54);
		double side = 2 * Radius * Math.sin(angleB);
		double sideA = side * Math.sin(angleB);

		double secondLayerY = Radius / 2;
		Vertex3 upperPivot = new Vertex3(0, 2 * Radius, 0);
		this.edges[0] = new Triangle( upperPivot,
		                              new Vertex3(-side / 2, secondLayerY , Radius * Math.sin(angleA)),
		                              new Vertex3(side / 2 , secondLayerY , Radius * Math.sin(angleA)),
		                              Color.PINK);

	}

	@Override
	protected void drawPivotPoints(Graphics2D g) {
		for (int i = 0; i < edges.length; i++)
		{
			for (Vertex3 vertex : edges[i].getVertices())
			{
				g.fillOval((int) vertex.getX() - pivotDiameter / 2, (int) vertex.getY() -  pivotDiameter / 2, pivotDiameter, pivotDiameter);
			}
		}
	}
}
