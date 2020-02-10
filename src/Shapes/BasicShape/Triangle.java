package Shapes.BasicShape;

import java.awt.*;

import Math.*;

public class Triangle extends BasicShape
{
	Color color;

	public Triangle(Vertex3 v1, Vertex3 v2, Vertex3 v3, Color color)
	{
		super(new Vertex3[]{v1, v2, v3});

		this.color = color;
	}

}
