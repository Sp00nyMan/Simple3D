import Shapes.Cube3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Math.*;

public class DisplayPanel extends JPanel implements KeyListener
{
	Cube3D cube;
	public static final double DEFAULT_ROTATION_ANGLE = 1; //deg
	public DisplayPanel() {
		cube = new Cube3D(200, 200, 200);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Draw axis
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.RED);
		g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		//

		g.translate(getWidth() / 2, getHeight() / 2); //Move origin to screen center

		cube.draw((Graphics2D) g); //draw cube
	}

	public static Matrix3 getTransform(double xAngle, double yAngle, double zAngle) {

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

	public void keyPressed(KeyEvent e) {
		double xAngle = 0;
		double yAngle = 0;
		double zAngle = 0;
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
					yAngle = -DEFAULT_ROTATION_ANGLE;
				break;
			case KeyEvent.VK_UP:
					yAngle = DEFAULT_ROTATION_ANGLE;
				break;
			case KeyEvent.VK_LEFT:
					xAngle = DEFAULT_ROTATION_ANGLE;
				break;
			case KeyEvent.VK_RIGHT:
					xAngle = -DEFAULT_ROTATION_ANGLE;
				break;
			case KeyEvent.VK_BACK_SPACE:
					zAngle = DEFAULT_ROTATION_ANGLE;
				break;
			case KeyEvent.VK_CONTROL:
					zAngle = -DEFAULT_ROTATION_ANGLE;
				break;
		}
		if(xAngle != 0 || yAngle != 0 || zAngle != 0)
			cube.rotate(getTransform(xAngle, yAngle, zAngle)); //Rotate cube at around one of axis
		System.out.println("x: " + xAngle + "; y: " + yAngle + "; z: " + zAngle);
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
