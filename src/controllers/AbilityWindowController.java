package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import windows.AbilitiesWindow;
import windows.Dialog;
import windows.Dialog.DialogResult;

public class AbilityWindowController implements ActionListener 
{
	Dialog dialog;
	
	public AbilityWindowController(Dialog dialog) 
	{
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Close":
				dialog.setResult(DialogResult.CLOSED);
				dialog.close();
				break;
			case "Save":
				dialog.setResult(DialogResult.OK);
				dialog.close();
				break;
			case "Buy":
				if(((AbilitiesWindow)dialog).buyAbility()==1)
					JOptionPane.showMessageDialog(null, "Not enough ability points to proceed", "No points", JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}

}
