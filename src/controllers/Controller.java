package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import handlers.CharacterHandler;
import handlers.FileHandler;
import windows.CharacterCreationWindow;
import windows.MainWindow;
import windows.SettingsWindow;
import windows.ShowCharacterWindow;
import windows.Dialog.DialogResult;

public class Controller implements ActionListener
{
	private Component owner;
	private MainWindow window;
	
	public Controller(MainWindow window, JFrame owner)
	{
		this.owner = owner;
		this.window = window;
		//this.ownerClass = owner.getClass();
	}
	
	/**
	 * <h2>Input-based action</h2>
	 * <ul>
	 * <li>New character: shows the new character window and return the data output of the window</li>
	 * <li>Edit character: shows the edit window on selected character and return the new data edited </li>
	 * <li>Settings: shows the settings dialog </li>
	 * <li>Delete: delete the selected character</li>
	 * <li>Exit: close the main window </li>
	 * </ul>
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "New character":
				CharacterCreationWindow creationWindow = new CharacterCreationWindow();
				creationWindow.showDialog();
				String[] d = creationWindow.getNewCharacter().split("\\|");
				d[0] = d[0].replaceAll(" ", "");
				boolean correct = !d[0].isEmpty();
				if(creationWindow.getResult() == DialogResult.OK && correct)
				{				
					FileHandler fh = new FileHandler();
					CharacterHandler ch = new CharacterHandler();
					ch.loadList(fh.getDb());
					ch.addLine(creationWindow.getNewCharacter());
					fh.setDb(ch.parseList());
					fh.writeFile();
					window.updateData();
				}
				else if(creationWindow.getResult() == DialogResult.OK && !correct)
				{
					JOptionPane.showMessageDialog(owner, "Character name should contains at least 1 char", "No name provided", JOptionPane.ERROR_MESSAGE);
				}
				break;
			/**
			 * 
			 */
			case "Edit character":
				if(window.getRow() !=  null)
				{
					ShowCharacterWindow showWindow = new ShowCharacterWindow();
					showWindow.loadData(window.getRow());
					showWindow.showDialog();
					if(showWindow.getResult() == DialogResult.OK)
					{
						FileHandler fh = new FileHandler();
						CharacterHandler ch = new CharacterHandler();
						ch.loadList(fh.getDb());
						String[] temp = showWindow.getEditedCharacter().split("\\|");
						String reconstruct = "";
						for(int i = 1; i < temp.length; i++)
						{
							reconstruct += temp[i];
							if(temp.length - 1 > i)
								reconstruct += "|";
						}
						ch.editChar(reconstruct, window.getSelectedRowIndex()+1);
						fh.setDb(ch.parseList());
						fh.writeFile();
						window.updateData();
					}
				}
				break;
			/**
			 * 
			 */
			case "Settings":
				SettingsWindow settingsWindow = new SettingsWindow();
				settingsWindow.showDialog();
				break;
				
			/**
			 * 
			 */
			case "Delete":
				window.deleteRow();
				break;
			/**
			 * 
			 */
			case "Exit":
				window.close();
				break;
				
			
		}
	}

}
