package Shapes;

import java.awt.*;

import Math.*;
import Shapes.BasicShape.Triangle;

public class Tetrahedron3D extends Basic3DShape
{

	public Tetrahedron3D() {

		Triangle[] triangles = new Triangle[4];
		triangles[0] = (new Triangle(new Vertex3(100, 100, 100),
		                             new Vertex3(-100, -100, 100),
		                             new Vertex3(-100, 100, -100),
		                             Color.WHITE));
		triangles[1] = (new Triangle(new Vertex3(100, 100, 100),
		                             new Vertex3(-100, -100, 100),
		                             new Vertex3(100, -100, -100),
		                             Color.RED));
		triangles[2] = (new Triangle(new Vertex3(-100, 100, -100),
		                             new Vertex3(100, -100, -100),
		                             new Vertex3(100, 100, 100),
		                             Color.GREEN));
		triangles[3] = (new Triangle(new Vertex3(-100, 100, -100),
		                             new Vertex3(100, -100, -100),
		                             new Vertex3(-100, -100, 100),
		                             Color.BLUE));
		this.edges = triangles.clone();
	}

	@Override
	protected void drawPivotPoints(Graphics2D g)
	{
		for (int i = 0; i < 2; i++)
		{
			for (Vertex3 vertex : edges[i].getVertices())
			{
				g.fillOval((int) vertex.getX() - pivotDiameter / 2, (int) vertex.getY() -  pivotDiameter / 2, pivotDiameter, pivotDiameter);
			}
		}
	}

}
