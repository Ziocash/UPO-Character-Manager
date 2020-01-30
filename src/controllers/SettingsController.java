package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import handlers.SettingsHandler;
import windows.Dialog;
import windows.SettingsWindow;

public class SettingsController implements ActionListener
{
	private Dialog dialog;
	
	public SettingsController(Dialog dialog)
	{
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
			case "Close":
				dialog.close();
				break;
			case "Browse...": 
				JButton button = (JButton)e.getSource();
				JFileChooser fileChooser  = new JFileChooser();
				switch(button.getName())
				{
					case "btnBrowseCharFile":
						fileChooser.setDialogTitle("Select characters file");
						break;
					case "btnBrowseAbilitiesFile":
						fileChooser.setDialogTitle("Select abilities file");
						break;
				}
				if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					switch(button.getName())
					{
						case "btnBrowseCharFile":
							SettingsHandler.setProperty("SaveFilePath", fileChooser.getSelectedFile().getPath());
							((SettingsWindow)dialog).updateData(); 
							break;
						case "btnBrowseAbilitiesFile":
							SettingsHandler.setProperty("AbilitiesFilePath", fileChooser.getSelectedFile().getPath());
							((SettingsWindow)dialog).updateData();
							break;
					}
				}
				break;		
		
			default:
				break;
		}
	}

}
