package windows;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import controllers.MainMenuController;

public class AdaptableWindow extends windows.Dialog
{
	/**
	 * 
	 */
	private JFrame owner;
	
	/**
	 * 
	 */
	private JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * 
	 */
	private JTextArea txtArea = new JTextArea();
	
	/**
	 * 
	 */
	private JMenuBar menuBar = new JMenuBar();	

	/**
	 * 
	 * @param owner
	 * @param title
	 * @param modType
	 */
	public AdaptableWindow(JFrame owner, String title, Dialog.ModalityType modType)
	{
		initializeComponents();
		this.owner = owner;
		dialog.setTitle("Characters Manager - " + title);
		dialog.setModalityType(modType);
		setDialogProperties(true, 400, 250, owner);
		setType(Type.POPUP);
		setCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		scrollPane.setViewportView(txtArea);
		txtArea.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		
		initializeMenu();
		dialog.setJMenuBar(menuBar);
		dialog.getContentPane().add(scrollPane);
	}

	/**
	 * 
	 */
	private void initializeMenu()
	{
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewWindow = new JMenuItem("New window");
		mnNewMenu.add(mntmNewWindow);
		
		MainMenuController newWindowController = new MainMenuController(owner);
		mntmNewWindow.addActionListener(newWindowController);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Delete");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		MainMenuController exitController = new MainMenuController(owner);
		mntmExit.addActionListener(exitController);
	}
	
	/**
	 * 
	 * @param text
	 */
	public synchronized void setText(String text)
	{
		txtArea.setText(text);
	}
	
	/**
	 * 
	 * @return
	 */
	public synchronized String getText()
	{
		return txtArea.getText();
	}
	
	/**
	 * 
	 * @param text
	 */
	public synchronized void appendText(String text)
	{
		txtArea.append(text);
	}
	
}
