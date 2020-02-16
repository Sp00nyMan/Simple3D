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
	public Triangle(Triangle other)
	{
		super(new Vertex3[]{other.get(0), other.get(1), other.get(2)});
		this.color = other.color;
	}

}
