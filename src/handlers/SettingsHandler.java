package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsHandler 
{
	/**
	 * Constant field: contains settings file path
	 */
	private static final String SETTINGS_FILE = "Settings.settings";
	
	/**
	 * Sets a property in settings file
	 * @param property Property given name
	 * @param value Property value
	 * @return
	 * {@code true} if the property is correctly set, else returns {@code false}
	 */
	public static boolean setProperty(String property, String value)
	{		
		try 
		{
			if(testFile())
			{
				Properties prop = new Properties();
				FileInputStream input = new FileInputStream(SETTINGS_FILE);
				prop.load(input);	
				input.close();
				FileOutputStream out = new FileOutputStream(SETTINGS_FILE);
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
	
	/**
	 * Retrieves a property in settings file
	 * @param property Property given name
	 * @return
	 * the property value if exists, else return {@code null}
	 */
	public static String retrieveProperty(String property)
	{
		try
		{
			if(testFile())
			{
				Properties prop = new Properties();
				FileInputStream input = new FileInputStream(SETTINGS_FILE);
				prop.load(input);
				input.close();
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
	
	/**
	 * Tests if settings file exists
	 * @return
	 * {@code true} if exists, else returns {@code false}
	 */
	private static boolean testFile()
	{
		if(new File(SETTINGS_FILE).isFile())			
			return true;
		else		
		{			
			File f = new File(SETTINGS_FILE);
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
