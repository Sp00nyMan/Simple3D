package Shapes;

import Shapes.BasicShape.Triangle;

import java.awt.*;

import Math.Vertex3;

public class Icosahedron3D extends Basic3DShape
{
	public Icosahedron3D()
	{
		this.edges = new Triangle[20];
		double Radius = 100;
		double angleB = Math.toRadians(180 / 5);

		double secondLayerY = -Radius / 2;
		Vertex3 upperPivot = new Vertex3(0, -Radius, 0);
		Vertex3 lowerPivot = new Vertex3(0, Radius, 0);
		//Generating upper "CONE"
		for (int i = 0, j = 0; i < 10; i += 2, j++)
		{
			this.edges[j] = new Triangle(upperPivot,
			                             new Vertex3(Radius * Math.sin(angleB * 2 * i), secondLayerY, Radius * Math.cos(angleB * 2 * i)),
			                             new Vertex3(Radius * Math.sin(angleB * 2 * (i + 1)), secondLayerY, Radius * Math.cos(angleB * 2 * (i + 1))),
			                             Color.BLACK);
		}
		//Generating lower "CONE"
		for (int i = 0, j = 5; i < 10; i += 2, j++)
		{
			this.edges[j] = new Triangle(lowerPivot,
			                             new Vertex3(Radius * Math.sin(angleB * 2 * i + Math.PI), -secondLayerY, Radius * Math.cos(angleB * 2 * i + Math.PI)),
			                             new Vertex3(Radius * Math.sin(angleB * 2 * (i + 1) + Math.PI), -secondLayerY, Radius * Math.cos(angleB * 2 * (i + 1) + Math.PI)),
			                             Color.BLACK);
		}
		//Generating middle ring
		for (int i = 0, j = 10; i < 10; i += 2, j += 2)
		{
			this.edges[j] = new Triangle(new Vertex3(Radius * Math.sin(angleB * 2 * (i + 3)), secondLayerY, Radius * Math.cos(angleB * 2 * (i + 3))),
			                             new Vertex3(Radius * Math.sin(angleB * 2 * i + Math.PI), -secondLayerY, Radius * Math.cos(angleB * 2 * i + Math.PI)),
			                             new Vertex3(Radius * Math.sin(angleB * 2 * (i + 1) + Math.PI), -secondLayerY, Radius * Math.cos(angleB * 2 * (i + 1) + Math.PI)),
			                             Color.BLACK);
			this.edges[j + 1] = new Triangle(new Vertex3(Radius * Math.sin(angleB * 2 * (i - 2) + Math.PI), -secondLayerY, Radius * Math.cos(angleB * 2 * (i - 2) + Math.PI)),
			                             new Vertex3(Radius * Math.sin(angleB * 2 * i), secondLayerY, Radius * Math.cos(angleB * 2 * i)),
			                             new Vertex3(Radius * Math.sin(angleB * 2 * (i + 1)), secondLayerY, Radius * Math.cos(angleB * 2 * (i + 1))),
			                             Color.BLACK);
		}
	}

	@Override
	protected void drawPivotPoints(Graphics2D g)
	{
		for (int i = 0; i < edges.length; i++)
		{
			for (Vertex3 vertex : edges[i].getVertices())
			{
				g.fillOval((int) vertex.getX() - pivotDiameter / 2, (int) vertex.getY() - pivotDiameter / 2, pivotDiameter, pivotDiameter);
			}
		}
	}
}
