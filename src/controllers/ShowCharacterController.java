package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import windows.ShowCharacterWindow;
import windows.AbilitiesWindow;
import windows.Dialog.DialogResult;

public class ShowCharacterController implements ActionListener 
{
	private windows.Dialog dialog;
	public ShowCharacterController(windows.Dialog dialog)
	{
		this.dialog = dialog;
	}
	
	/**
	 * <h2>Input-based action</h2>
	 * <ul>
	 * <li>Show ability: shows abilities window</li>
	 * <li>Level up: levels up current character</li>
	 * <li>OK: saves and closes the dialog</li>
	 * <li>Cancel: cancels and closes the dialog</li>
	 * </ul>
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Show ability":
				AbilitiesWindow abilitiesWindow = new AbilitiesWindow();
				abilitiesWindow.showDialog(((ShowCharacterWindow)dialog).getCharacter());
				if(abilitiesWindow.getResult() == DialogResult.OK)
				{
					((ShowCharacterWindow)dialog).getCharacter().setAbilities(abilitiesWindow.getCharacterAbilities());	
					((ShowCharacterWindow)dialog).update();
				}
				break;
				
			case "Level up":
				if(!((ShowCharacterWindow)dialog).getCharacter().isMaxLevel())
				{
					((ShowCharacterWindow)dialog).levelUp();
					System.gc();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You're alredy at max level", "Max level reached", JOptionPane.INFORMATION_MESSAGE);
				}
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
