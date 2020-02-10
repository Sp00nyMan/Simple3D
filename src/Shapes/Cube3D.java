package Shapes;

import java.awt.*;

import Math.*;
import Shapes.BasicShape.BasicShape;
import Shapes.BasicShape.Rect;

public class Cube3D extends Basic3DShape
{

	public Cube3D(double width, double height, double length)
	{
		double halfW = width / 2;
		double halfH = height / 2;
		double halfL = length / 2;
		Vertex3 backLeftUpper = new Vertex3(-halfW, halfH, -halfL);
		Vertex3 backRightUpper = new Vertex3(halfW, halfH, -halfL);
		Vertex3 backLeftLower = new Vertex3(-halfW, -halfH, -halfL);
		Vertex3 backRightLower = new Vertex3(halfW, -halfH, -halfL);

		Vertex3 frontLeftUpper = new Vertex3(-halfW, halfH, halfL);
		Vertex3 frontRightUpper = new Vertex3(halfW, halfH, halfL);
		Vertex3 frontLeftLower = new Vertex3(-halfW, -halfH, halfL);
		Vertex3 frontRightLower = new Vertex3(halfW, -halfH, halfL);

		Rect[] rects = new Rect[6];

		//Задний квадрат куба (-Z = const)
		rects[0] = new Rect( backLeftUpper,
		                     backRightUpper,
		                     backRightLower,
		                     backLeftLower,
		                     Color.WHITE);
		//Передний квадрат куба(Z = const)
		rects[1] = new Rect( frontLeftUpper,
		                     frontRightUpper,
		                     frontRightLower,
		                     frontLeftLower,
		                     Color.WHITE);
		//Левый квадрат куба (-X = const)
		rects[2] = new Rect(backLeftUpper, //Левая верхняя точка
		                    frontLeftUpper, //Правая верхняя точка
		                    frontLeftLower, // Правая нижняя точка
		                    backLeftLower, //Левая нижняя точка
		                    Color.WHITE);
		//Правый квадрат куба(X = const)
		rects[3] = new Rect(backRightUpper, //Левая верхняя точка
		                    frontRightUpper, //Правая верхняя точка
		                    frontRightLower, // Правая нижняя точка
		                    backRightLower, //Левая нижняя точка
		                    Color.WHITE);
		//Верхний квадрат куба (Y = const)
		rects[4] = new Rect(backLeftUpper, //Левая верхняя точка
		                    frontLeftUpper, //Правая верхняя точка
		                    frontRightUpper, // Правая нижняя точка
		                    backRightUpper, //Левая нижняя точка
		                    Color.WHITE);
		//Нижний квадрат куба (-Y = const)
		rects[5] = new Rect(backLeftLower, //Левая верхняя точка
		                    frontLeftLower, //Правая верхняя точка
		                    frontRightLower, // Правая нижняя точка
		                    backRightLower, //Левая нижняя точка
		                    Color.WHITE);
		this.edges = rects.clone();
	}

	@Override
	protected void drawPivotPoints(Graphics2D g)
	{
		for (int i = 0; i < 2; i++)
		{
			for (Vertex3 vertex : edges[i].getVertices())
			{
				g.fillOval((int) vertex.getX() - pivotOffset, (int) vertex.getY() - pivotOffset, pivotDiameter, pivotDiameter);
			}
		}
	}
}
