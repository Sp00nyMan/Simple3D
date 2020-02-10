package Shapes;

import java.awt.*;

import Math.*;

public class Tetrahedron3D
{
	Triangle[] triangles = new Triangle[4];

	public Tetrahedron3D() {
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
	}

	public void draw(Graphics2D g, double width, double height, Matrix3 transform) {
		for (Triangle triangle : triangles)
		{
			g.setColor(Color.ORANGE);
			triangle.draw(g, transform);
		}

		g.setColor(Color.BLUE);
		drawPivotPoints(g, transform);
	}

	private void drawPivotPoints(Graphics2D g, Matrix3 transoform)
	{
		final int offset = 4;
		final int diameter = 8;
		for (int i = 0; i < 2; i++)
		{
			Triangle rotated = triangles[i].getRotated(transoform);

			g.fillOval((int) rotated.v1.getX() - offset, (int) rotated.v1.getY() - offset, diameter, diameter);
			g.fillOval((int) rotated.v2.getX() - offset, (int) rotated.v2.getY() - offset, diameter, diameter);
			g.fillOval((int) rotated.v3.getX() - offset, (int) rotated.v3.getY() - offset, diameter, diameter);
		}
	}

}
