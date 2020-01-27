package controllers;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import handlers.CharacterHandler;
import handlers.FileHandler;
import windows.CharacterCreationWindow;
import windows.MainWindow;
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
				
			case "Edit character":
				ShowCharacterWindow showWindow = new ShowCharacterWindow();
				showWindow.loadData(window.getRow());
				showWindow.showDialog();
				break;
				
			case "Delete":
				window.deleteRow();
				break;
				
			case "Exit":
				window.close();
				break;
				
			
		}
	}

}
