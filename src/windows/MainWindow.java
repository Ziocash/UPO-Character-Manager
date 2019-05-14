package windows;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class MainWindow
{
	private JFrame frame;

	private void initializeComponents()
	{
		frame = new JFrame();
		frame.setTitle("Characters Manager - Finestra principale");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		//------------------------------------------------
		JTextArea txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
	}
	
	public void show()
	{
		initializeComponents();
		frame.setVisible(true);
	}
	
	public boolean isShown()
	{
		return frame.isVisible();
	}

	public void close()
	{
		frame.setVisible(false);		
	}
}
