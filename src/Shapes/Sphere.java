package Shapes;

import java.awt.*;

public class Sphere extends Basic3DShape
{
	private double radius;
	public Sphere(double centerX, double centerY, double centerZ, double radius)
	{
		this.radius = radius;
	}
	@Override
	protected void drawPivotPoints(Graphics2D g) {

	}
}
