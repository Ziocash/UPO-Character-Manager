package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import windows.MainWindow;

public class MenuController implements ActionListener
{
	private JMenuItem item = new JMenuItem();
	private MainWindow owner = new MainWindow();
	
	public MenuController(JMenuItem menuItem, MainWindow ownFrame)
	{
		super();
		item = menuItem;
		owner = ownFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String name = item.getText();
		switch(name)
		{
			case "New window":
				new MainWindow().show();
				break;
			case "D":
				break;
			case "A":
				break;
			case "G":
				break;
			case "Exit":
				owner.close();
				break;
			default:
				break;
		}
	}
}
