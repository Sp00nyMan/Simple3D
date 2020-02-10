import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		DisplayPanel display = new DisplayPanel();
		pane.add(display, BorderLayout.CENTER);

		setBounds(40, 40, 500, 500);

		addKeyListener(display);
	}

	public void init()
	{
		setVisible(true);
	}

	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		window.init();
	}
}
