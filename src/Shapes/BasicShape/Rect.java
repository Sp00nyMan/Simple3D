package Shapes.BasicShape;
import Math.*;

import java.awt.*;

public class Rect extends BasicShape
{
	Color color;

	public Rect(Vertex3 v1, Vertex3 v2, Vertex3 v3, Vertex3 v4, Color color)
	{
		super(new Vertex3[]{v1, v2, v3, v4});
		this.color = color;
	}
}
