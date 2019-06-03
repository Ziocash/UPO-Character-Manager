package controllers;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import windows.AdaptableWindow;

public class MainMenuController implements ActionListener
{
	private JMenuItem item = new JMenuItem();
	private JFrame owner = new JFrame();
	
	public MainMenuController(JMenuItem menuItem, JFrame ownFrame)
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
				AdaptableWindow w = new AdaptableWindow(owner, "", Dialog.ModalityType.DOCUMENT_MODAL);
				w.appendText("You're goddamn right bruh");
				w.show();
				break;
			case "D":
				break;
			case "A":
				break;
			case "G":
				break;
			case "Exit":
				owner.dispatchEvent(new WindowEvent(owner, WindowEvent.WINDOW_CLOSING));
				break;
			default:
				break;
		}
	}
}
