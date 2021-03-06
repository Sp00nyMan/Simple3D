package Math;

public class Vertex3 implements Cloneable
{
	double x;
	double y;
	double z;

	public Vertex3(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}

	@Override
	public Vertex3 clone()
	{
		return new Vertex3(x, y, z);
	}
}
