package windows;

import java.awt.Dialog;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import controllers.MainMenuController;

public class AdaptableWindow
{
	private JDialog frame;
	private JFrame owner;
	private Dialog.ModalityType modType;
	private String title;
	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea txtArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();	

	public AdaptableWindow(JFrame owner, String title, Dialog.ModalityType modType)
	{
		this.owner = owner;
		this.modType = modType;
		this.title = "Characters Manager - " + title;
		initializeComponents();
	}
	
	private void initializeComponents()
	{
		frame = new JDialog(owner, title, modType);
		frame.setBounds(0, 0, 400, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);		
		
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
		
		MainMenuController newWindowController = new MainMenuController(mntmNewWindow, null);
		mntmNewWindow.addActionListener(newWindowController);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Delete");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		MainMenuController exitController = new MainMenuController(mntmExit, null);
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
		frame.setVisible(true);
	}
	
	public boolean isShown()
	{
		return frame.isVisible();
	}
}
