package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import handlers.FileHandler;

public class ButtonController implements ActionListener
{
	private JButton item = new JButton();
	private JFrame itemParent = new JFrame();
	
	public ButtonController(JButton button, JFrame parent)
	{
		item = button;
		itemParent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String content = item.getText();
		switch(content)
		{
			case "Create": 
				Component testObjects = itemParent;
				itemParent.dispatchEvent(new WindowEvent(itemParent, WindowEvent.WINDOW_CLOSING));
		}
	}
	
}
