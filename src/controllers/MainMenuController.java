package controllers;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import handlers.CharacterHandler;
import handlers.FileHandler;
import windows.AdaptableWindow;
import windows.CharacterCreationWindow;

public class MainMenuController implements ActionListener
{
	private JFrame owner = new JFrame();
	private FileHandler fHandler = new FileHandler();
	private CharacterHandler cHandler = new CharacterHandler();
	
	public MainMenuController(JFrame ownerFrame)
	{
		owner = ownerFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String name = e.getActionCommand();
		switch(name)
		{
			case "New character":
				CharacterCreationWindow creationWindow = new CharacterCreationWindow();
				creationWindow.showDialog();	
				cHandler.addLine(creationWindow.getNewCharacter());
				ArrayList<ArrayList<String>> tempArrayList = fHandler.getDb();
				tempArrayList.add(cHandler.parseList().get(0));
				fHandler.setDb(tempArrayList);
				fHandler.writeFile();
				owner.repaint();
				break;
			case "Exit":
				owner.dispatchEvent(new WindowEvent(owner, WindowEvent.WINDOW_CLOSING));
				break;
			default:
				break;
		}
	}
}
