package windows;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import controllers.MenuController;

public class MainWindow
{
	private JFrame frame;
	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea txtArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();	

	private void initializeComponents()
	{
		frame = new JFrame();
		frame.setTitle("Characters Manager - Finestra principale");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//------------------------------------------------		
		scrollPane.setViewportView(txtArea);
		txtArea.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		
		initializeMenu();
		frame.setJMenuBar(menuBar);
		frame.add(scrollPane);
	}
	
	private void initializeMenu()
	{
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewWindow = new JMenuItem("New window");
		mnNewMenu.add(mntmNewWindow);
		
		MenuController newWindowController = new MenuController(mntmNewWindow, this);
		mntmNewWindow.addActionListener(newWindowController);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Delete");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		MenuController exitController = new MenuController(mntmExit, this);
		mntmExit.addActionListener(exitController);
	}
	
	public synchronized void setText(String text)
	{
		txtArea.setText(text);
	}
	
	public synchronized String getText()
	{
		return txtArea.getText();
	}
	
	public synchronized void appendText(String text)
	{
		txtArea.append(text);
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
		frame.dispose();
	}
}
