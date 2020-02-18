package handlers;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileHandler 
{
	/**
	 * Path to characters file
	 */
	private String charactersFile = ""; //path/to/file
	
	/**
	 * Path to abilities file
	 */
	private String abilitiesFile = "";
	
	/**
	 * Collection which contains all the db file lines
	 */
	private ArrayList<ArrayList<String>> db = new ArrayList<ArrayList<String>>();
	
	/**
	 * Collection which contains all abilities
	 */
	private ArrayList<String> dbAbility = new ArrayList<String>(); 
	/**
	 * Class constructor
	 */
	public FileHandler()
	{
		try
		{
			String path = SettingsHandler.retrieveProperty("SaveFilePath");
			String abilitiesPath = SettingsHandler.retrieveProperty("AbilitiesFilePath");
			if(path == null || path.isEmpty() || !(new File(path).exists()) || abilitiesPath == null || abilitiesPath.isEmpty() || !(new File(abilitiesPath).exists()))
				intializeClass();
			else
			{
				charactersFile = path;
				abilitiesFile = abilitiesPath;
			}
				
		}
		catch(Exception e)
		{
			intializeClass();
		}
		
		try 
		{
			readFile();
			readAbilityFile();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the DB value 
	 * 
	 * @return the DB value
	 */
	public ArrayList<ArrayList<String>> getDb()
	{
		return db;
	}
	
	/**
	 * Returns the DBAbility value
	 * 
	 * @return the DBAbility value
	 */
	public ArrayList<String> getDbAbilities()
	{
		return dbAbility;
	}
	
	/**
	 * Clears the db then adds a collection to it
	 * 
	 * @param db Collection that will be added to the db
	 */
	public void setDb(Collection<? extends ArrayList<String>> db)
	{
		this.db.clear();
		this.db.addAll(db);
	}
	
	/**
	 * Returns settings file path 
	 * @return empty string or file path if set
	 */
	public String getFilePath()
	{
		return charactersFile;
	}
	
	/**
	 * Writes the db array into the file at path {@link #charactersFile}
	 * 
	 * @return {@code true} if the file is correctly written, {@code false} in the other cases
	 */
	public boolean writeFile() 
	{
		try
		{
			FileWriter fw = new FileWriter(charactersFile, false);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    
		    //------
		    out.write("");
			for(ArrayList<String> row : db)
			{
				String content = "";
				int i = 0;
				int maxI = row.size() - 1;
				for(int temp = 0; temp < row.size(); temp++)
				{
					content += row.get(temp); 
					if(maxI > i)
						content += "|";
					i++;
				}
				out.append(content + System.lineSeparator());			
			}			
			out.close();
			return true;
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
			return false;
		}
	}
	
	
	//--------------------------------------------------Private methods----------------------------------------------------------------------//
	
	/**
	 * Reads the file with a default separator style ("|")
	 * 
	 * @return a list of lists which contains all file lines ({@code ArrayList<ArrayList<String>>})
	 */
	private void readFile() 
	{
		try
		{
			//If the file exists 
			if(testFile(charactersFile, true))
			{
				db.clear();
				File file = new File(charactersFile);
				List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
				for(String item : list)
				{
					ArrayList<String> splitted = new ArrayList<String>(Arrays.asList(item.split("\\|")));
					db.add(splitted);
				}			
			}
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return;
	}
	
	/**
	 * Initialize the class with the correct instruction sequence
	 * 
	 * (Automatic error handling included)
	 */
	private void intializeClass()
	{
		int result = 0;
		if(!testFile(charactersFile, true) || !testFile(abilitiesFile, true))
		{
			if(charactersFile.isEmpty())
			{
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file", "txt");
				fc.setFileFilter(filter);
				fc.setDialogTitle("Select characters file");
				result = fc.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					charactersFile = fc.getSelectedFile().getPath();
					if(!charactersFile.contains(".txt"))
						charactersFile.concat(".txt");
					testFile(charactersFile, false);
					SettingsHandler.setProperty("SaveFilePath", charactersFile);
				}			
			}
			if(abilitiesFile.isEmpty())
			{
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file", "txt");
				fc.setFileFilter(filter);
				fc.setDialogTitle("Select abilities file");
				result = fc.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					abilitiesFile = fc.getSelectedFile().getPath();
					if(!abilitiesFile.contains(".txt"))
						abilitiesFile.concat(".txt");
					testFile(abilitiesFile, false);
					SettingsHandler.setProperty("AbilitiesFilePath", abilitiesFile);
				}			
			}
			
			
		}
		else
		{
			testFile(abilitiesFile, true);
			testFile(charactersFile, true);
		}
	}
	
	/**
	 * Test if the file which should save information exists
	 * @param onlyCheck Specify if the method should create the file or only checks if it exists
	 * @return {@code true} if the file exists, {@code false} in other cases
	 */
	private boolean testFile(String path, boolean onlyCheck)
	{
		if(new File(path).isFile() && onlyCheck)			
			return true;
		else
		{
			if(!onlyCheck)
			{
				File f = new File(path);
				try
				{					
					return f.createNewFile();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore nella creazione del file", JOptionPane.ERROR_MESSAGE);
					return false;
				}				
			}
			return false;
		}
			
	}
	
	/**
	 * Returns a {@code boolean} when dbAbility is correctly set, else return {@code false}
	 * @return a {@code boolean} when dbAbility is correctly set, else return {@code false}
	 */
	private boolean readAbilityFile()
	{
		try
		{
			//If the file exists 
			if(testFile(abilitiesFile, true))
			{
				dbAbility.clear();
				File file = new File(abilitiesFile);
				dbAbility = (ArrayList<String>) Files.readAllLines(file.toPath(), Charset.defaultCharset());
							
			}
			return true;
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
			return false;
		}
		
	}

}
