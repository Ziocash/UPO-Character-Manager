package windows;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainWindow
{
	private JFrame frame = new JFrame();
	
	private void initializeComponents()
	{
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		
		//------------------------------------------------
		JTextArea txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
	}
	
	public boolean show()
	{
		initializeComponents();
		frame.setVisible(true);
		return frame.isVisible();
	}

	public void close()
	{
		frame.setVisible(false);		
	}
}
