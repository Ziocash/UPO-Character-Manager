package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ShowCharacterController implements ActionListener 
{
	private windows.Dialog dialog;
	private JFrame owner;
	
	public ShowCharacterController(windows.Dialog dialog, JFrame owner)
	{
		this.dialog = dialog;
		this.owner = owner;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		
			case "Close":
				dialog.close();
				break;
				default:
					System.out.println(e.getActionCommand());
					break;
		}
	}

}
