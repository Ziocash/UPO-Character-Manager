package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import windows.ShowCharacterWindow;
import windows.Dialog.DialogResult;

public class ShowCharacterController implements ActionListener 
{
	private windows.Dialog dialog;
	public ShowCharacterController(windows.Dialog dialog)
	{
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Show ability":
				break;
			case "Level up":
				((ShowCharacterWindow)dialog).levelUp();
				System.gc();
				break;
			case "OK":
				dialog.setResult(DialogResult.OK);
				dialog.close();
				break;
			case "Cancel":
				dialog.setResult(DialogResult.CANCEL);
				dialog.close();
				break;
			default:
				dialog.setResult(DialogResult.CLOSED);
				break;
		}
	}

}
