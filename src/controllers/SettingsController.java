package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file", "txt");
				fileChooser.setFileFilter(filter);
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
							String tempString = fileChooser.getSelectedFile().getPath();
							if(!tempString.contains(".txt"))
								tempString.concat(".txt");
							SettingsHandler.setProperty("SaveFilePath", tempString);
							((SettingsWindow)dialog).updateData(); 
							break;
						case "btnBrowseAbilitiesFile":
							tempString = fileChooser.getSelectedFile().getPath();
							if(!tempString.contains(".txt"))
								tempString.concat(".txt");
							SettingsHandler.setProperty("AbilitiesFilePath", tempString);
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
