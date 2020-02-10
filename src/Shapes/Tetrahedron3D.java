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

	public void draw(Graphics2D g) {
		for (Triangle triangle : triangles)
		{
			g.setColor(Color.ORANGE);
			triangle.draw(g);
		}
		g.setColor(Color.BLUE);
		drawPivotPoints(g);
	}

	private void drawPivotPoints(Graphics2D g)
	{
		final int offset = 4;
		final int diameter = 8;
		for (int i = 0; i < 2; i++)
		{
			g.fillOval((int) triangles[i].v1.getX() - offset, (int) triangles[i].v1.getY() - offset, diameter, diameter);
			g.fillOval((int) triangles[i].v2.getX() - offset, (int) triangles[i].v2.getY() - offset, diameter, diameter);
			g.fillOval((int) triangles[i].v3.getX() - offset, (int) triangles[i].v3.getY() - offset, diameter, diameter);
		}
	}

	public void rotate(Matrix3 transform)
	{
		for (Triangle triangle : triangles)
		{
			triangle.rotate(transform);
		}
	}

}
