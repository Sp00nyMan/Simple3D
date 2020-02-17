package Shapes.BasicShape;
import Math.Vertex3;

import java.awt.*;

public class Pentagon extends BasicShape
{
	Color color;
	Pentagon(Vertex3[] array, Color color) {
		super(array);
		this.color = color;
	}
	public Pentagon(Vertex3 center, double radius)
	{
		super(new Vertex3[]{center});
		//СГЕНЕРИТЬ 5 вершин по алгоритму https://qna.habr.com/q/57444
	}

}
