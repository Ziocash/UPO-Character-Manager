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
import windows.MainWindow;
import windows.Window;

public class Controller implements ActionListener
{
	private Component owner;
	private MainWindow window;
	
	public Controller(MainWindow window, JFrame owner)
	{
		this.owner = owner;
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
				FileHandler fh = new FileHandler();
				CharacterHandler ch = new CharacterHandler();
				ch.loadList(fh.getDb());
				ch.addLine(creationWindow.getNewCharacter());
				fh.setDb(ch.parseList());
				fh.writeFile();
				window.updateData();
				break;
				
			case "Exit":
				owner.dispatchEvent(new WindowEvent((java.awt.Window) owner, WindowEvent.WINDOW_CLOSING));
				break;
				
			
		}
	}

}
