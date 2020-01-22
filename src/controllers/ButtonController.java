package controllers;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import handlers.CharacterHandler;
import handlers.FileHandler;

@Deprecated
public class ButtonController implements ActionListener
{
	private Component itemParent;	
	
	public ButtonController(JFrame parent)
	{
		itemParent = parent;
	}
	
	public ButtonController(JDialog parent)
	{
		itemParent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{		
		
		switch(e.getActionCommand())
		{
			case "Create":
				itemParent.dispatchEvent(new WindowEvent((Window) itemParent, WindowEvent.WINDOW_CLOSING));
		}
	}
	
}
