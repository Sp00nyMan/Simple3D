package Math;

import java.util.Arrays;

public class Matrix3
{
	double[] matrix = new double[9];
	public Matrix3(Vertex3 row1, Vertex3 row2, Vertex3 row3) {
			matrix[0] = row1.x;
			matrix[1] = row1.y;
			matrix[2] = row1.z;

			matrix[3] = row2.x;
			matrix[4] = row2.y;
			matrix[5] = row2.z;

			matrix[6] = row3.x;
			matrix[7] = row3.y;
			matrix[8] = row3.z;
	}
	public Matrix3() {
		Arrays.fill(matrix, 0);
	}
	public Matrix3(double[] other) {
		matrix = other;
	}

	public Matrix3 multiply(Matrix3 other) {
		double[] result = new double[9];

		for (int row = 0; row < 3; row++)
			for (int column = 0; column < 3; column++)
				for (int i = 0; i < 3; i++)
					result[row * 3 + column] += this.matrix[row * 3 + i] * other.matrix[i * 3 + column];


		return new Matrix3(result);
	}

	public Vertex3 transform(Vertex3 input) {
		return new Vertex3(
				input.getX() * matrix[0] + input.getY() * matrix[3] + input.getZ() * matrix[6],
				input.getX() * matrix[1] + input.getY() * matrix[4] + input.getZ() * matrix[7],
				input.getX() * matrix[2] + input.getY() * matrix[5] + input.getZ() * matrix[8]
		);
	}
}
