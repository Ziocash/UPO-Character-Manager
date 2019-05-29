package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import windows.MainWindow;

public class Controller implements ActionListener
{
	private JMenuItem item = new JMenuItem();
	
	public Controller(JMenuItem menuItem)
	{
		super();
		item = menuItem;
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
				System.exit(0);
				break;
			default:
				break;
		}
	}
}
