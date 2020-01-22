package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JFrame;

import handlers.CharacterHandler;
import handlers.FileHandler;
import windows.CharacterCreationWindow;
import windows.Dialog;
import windows.MainWindow;
import windows.Window;
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
				if(creationWindow.getResult() == DialogResult.OK)
				{				
					FileHandler fh = new FileHandler();
					CharacterHandler ch = new CharacterHandler();
					ch.loadList(fh.getDb());
					ch.addLine(creationWindow.getNewCharacter());
					fh.setDb(ch.parseList());
					fh.writeFile();
					window.updateData();
				}
				break;
				
			case "Exit":
				window.close();
				break;
				
			
		}
	}

}
