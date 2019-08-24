package handlers;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileHandler 
{
	/**
	 * Path to the save file
	 */
	private String pathOfFile = ""; //path/to/file
	
	/**
	 * 
	 */
	private ArrayList<ArrayList<String>> db = new ArrayList<ArrayList<String>>();
	
	/**
	 * Class constructor
	 */
	public FileHandler()
	{
		try
		{
			String path = SettingsHandler.retrieveProperty("SaveFilePath");
			if(path == null || path.isEmpty() || !(new File(path).exists()))
				intializeClass();
			else
				pathOfFile = path;			
				
		}
		catch(Exception e)
		{
			intializeClass();
		}
		
		try 
		{
			readFile();
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
	 * Returns settings file path 
	 * @return empty string or file path if set
	 */
	public String getFilePath()
	{
		return pathOfFile;
	}
	
	/**
	 * Writes the db array into the file at path {@link #pathOfFile}
	 * 
	 * @param db line id
	 * @return {@code true} if the file is correctly written, {@code false} in the other cases
	 */
	public boolean writeLine(String line,int id)
	{
		if(db.remove(search(id)))
			return addLine(line);
		return false;		
	}
	
	/**
	 * Writes the db array into the file at path {@link #pathOfFile}
	 * 
	 * @param db
	 * @return {@code true} if the file is correctly written, {@code false} in the other cases
	 */
	public boolean writeFile() 
	{
		try
		{
			FileWriter fw = new FileWriter(pathOfFile, false);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    
		    //------
		    out.write("");
			for(ArrayList<String> row : db)
			{
				String content = "";
				int i = 0;
				int maxI = row.size() - 1;
				for(String item : row)
				{
					content += item;
					if(maxI > i)
						content += "|";
					i++;
				}
				out.append(content + "\n");			
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
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id)
	{
		ArrayList<String> arraySearch = search(id);
		if(db.remove(arraySearch))
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
	
	//--------------------------------------------------Private methods----------------------------------------------------------------------//
	
	/**
	 * Reads the file with a default separator style ("|")
	 * @return a list of lists which contains all file lines ({@code ArrayList<ArrayList<String>>})
	 */
	private void readFile() 
	{
		try
		{
			//If the file exists 
			if(testFile(true))
			{
				File file = new File(pathOfFile);
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
		if(!testFile(true))
		{
			if(pathOfFile.isEmpty())
			{
				JFileChooser fc = new JFileChooser();
				result = fc.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					pathOfFile = fc.getSelectedFile().getPath();
					testFile(false);
					SettingsHandler.setProperty("SaveFilePath", pathOfFile);
				}			
			}
			
		}
		else
			testFile(true);
	}
	
	/**
	 * Test if the file which should save information exists
	 * @param onlyCheck Specify if the method should create the file or only checks if it exists
	 * @return {@code true} if the file exists, {@code false} in other cases
	 */
	private boolean testFile(boolean onlyCheck)
	{
		if(new File(pathOfFile).isFile() && onlyCheck)			
			return true;
		else
		{
			if(!onlyCheck)
			{
				File f = new File(pathOfFile);
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

}
