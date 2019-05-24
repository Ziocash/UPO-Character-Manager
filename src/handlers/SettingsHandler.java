package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsHandler 
{
	private static final String settingsFile = "Settings.settings";
	
	public static boolean setProperty(String property, String value)
	{
		
		Properties prop = new Properties();
		try 
		{
			if(testFile())
			{
				FileInputStream input = new FileInputStream(settingsFile);
				prop.load(input);	
				input.close();
				FileOutputStream out = new FileOutputStream(settingsFile);
				prop.setProperty(property, value);
				prop.store(out, null);
				out.close();
				return true;
			}
			return false;
			
		} 
		catch (Exception e) 
		{		
			e.printStackTrace();
			return false;
		}
	}
	
	public static String retrieveProperty(String property)
	{
		try
		{
			if(testFile())
			{
				Properties prop = new Properties();
				FileInputStream input = new FileInputStream(settingsFile);
				prop.load(input);	
				return prop.getProperty(property);
			}
			else
				return null;
		} 		
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	private static boolean testFile()
	{
		if(new File(settingsFile).isFile())			
			return true;
		else		
		{			
			File f = new File(settingsFile);
			try 
			{
				f.createNewFile();
				return true;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}			
			return false;
		}
			
	}
}
