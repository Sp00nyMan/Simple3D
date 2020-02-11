import Shapes.Basic3DShape;
import Shapes.Cube3D;
import Shapes.Tetrahedron3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class DisplayPanel extends JPanel implements KeyListener
{
	Basic3DShape shape;
	public static final double DEFAULT_ROTATION_ANGLE = 3; //deg
	public DisplayPanel() {
		shape = new Tetrahedron3D();
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

		shape.draw((Graphics2D) g); //draw cube
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
			shape.rotate(xAngle, yAngle, zAngle); //Rotate cube at around one of axis
		System.out.println("x: " + xAngle + "; y: " + yAngle + "; z: " + zAngle);
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
