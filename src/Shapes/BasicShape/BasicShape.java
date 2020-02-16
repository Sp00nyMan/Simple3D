package Shapes.BasicShape;
import Math.*;

import java.awt.*;
import java.awt.geom.Path2D;

public abstract class BasicShape
{
	private Vertex3[] vertices;
	private int verticesSize;

	BasicShape(Vertex3[] array)
	{
		vertices = array.clone();
		verticesSize = vertices.length;
	}

	public void draw(Graphics2D g)
	{
		Path2D path = new Path2D.Double();
		path.moveTo(vertices[0].getX(), vertices[0].getY());

		for (int i = 1; i < verticesSize; i++)
		{
			path.lineTo(vertices[i].getX(), vertices[i].getY());
		}
		path.closePath();

		g.draw(path);
	}

	public void rotate(double xAngel, double yAngle, double zAngle)
	{
		Matrix3 transform = getTransform(xAngel, yAngle, zAngle);

		for (int i = 0; i < vertices.length; i++)
		{
			vertices[i] = transform.transform(vertices[i]);
		}
	}

	public Vertex3 get(int index){
		if(index < 0 && index >= verticesSize)
			throw new IndexOutOfBoundsException();
		return vertices[index];
	}
	public Vertex3[] getVertices(){
		return vertices;
	}

	private static Matrix3 getTransform(double xAngle, double yAngle, double zAngle) {

		//На главной диагонали всегда косинус, чтобы при угле наклона 0 получалась единичная матрица и фигура не вращалась
		Matrix3 XZTransform = new Matrix3(new Vertex3(Math.cos(Math.toRadians(xAngle)), 0, Math.sin(Math.toRadians(xAngle))),
		                                  new Vertex3(0, 1, 0),
		                                  new Vertex3(-Math.sin(Math.toRadians(xAngle)), 0, Math.cos(Math.toRadians(xAngle)))
		);
		Matrix3 YZTransform = new Matrix3(new Vertex3(1, 0, 0),
		                                  new Vertex3(0, Math.cos(Math.toRadians(yAngle)), -Math.sin(Math.toRadians(yAngle))),
		                                  new Vertex3(0, Math.sin(Math.toRadians(yAngle)), Math.cos(Math.toRadians(yAngle)))
		);
		Matrix3 XYTransform = new Matrix3(new Vertex3(Math.cos(Math.toRadians(zAngle)), -Math.sin(Math.toRadians(zAngle)), 0),
		                                  new Vertex3(Math.sin(Math.toRadians(zAngle)), Math.cos(Math.toRadians(zAngle)), 0),
		                                  new Vertex3(0, 0, 1)
		);
		return XZTransform.multiply(YZTransform).multiply(XYTransform);
	}
}
