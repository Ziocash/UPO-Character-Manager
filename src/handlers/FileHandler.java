package handlers;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	 * 
	 */
	private String pathOfFile = ""; //path/to/file
	
	/**
	 * 
	 */
	public FileHandler()
	{
		try
		{
			String path = SettingsHandler.retrieveProperty("SaveFilePath");
			if(path == null || path.isEmpty())
				intializeClass();
			else
				pathOfFile = path;
			
				
		}
		catch(Exception e)
		{
			intializeClass();
		}
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
		{
			testFile(true);
		}
	}
	
	/**
	 * Test if the file which should save information exists
	 * @param onlyCheck specify if the method should create the file or only checks if it exists
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
					f.createNewFile();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore nella creazione del file", JOptionPane.ERROR_MESSAGE);
				}
				return true;
			}
			return false;
		}
			
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
	 * Reads the file with a default separator style ("|")
	 * @return an 
	 */
	public ArrayList<ArrayList<String>> readFile() 
	{
		ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();		
		
		try
		{
			if(testFile(true))
			{
				File file = new File(pathOfFile);
				List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
				for(String item : list)
				{
					ArrayList<String> y = new ArrayList<String>(Arrays.asList(item.split("\\|")));
					content.add(y);
				}			
			}
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return content;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<String> search(int id) 
	{
		ArrayList<ArrayList<String>> x = readFile();
		if(x != null)
			for (ArrayList<String> item : x)
			{
				if(item.indexOf(Integer.toString(id)) != -1)				
				{
					return item;
				}	
			}
		return null;
	}

	/**
	 * 
	 * @param Id
	 * @param name
	 * @param type
	 * @return
	 */
	public boolean writeFile(String line) 
	{
		ArrayList<String> flag = search(1);
		if(flag == null)
		{
			try
			{
				if(!testFile(true))
				{
					FileWriter fw = new FileWriter(pathOfFile, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw);
					out.append(line);			
					out.close();
				}
				
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			return true;
		}
		else
			return false;
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id)
	{		
		//
		ArrayList<ArrayList<String>> db = readFile();
		ArrayList<String> arraySearch = search(id);
		db.remove(arraySearch);	
		try
		{
			//
			FileWriter fw = new FileWriter(pathOfFile, false);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    
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
	 * @return
	 */
	public int getLastID()
	{
		if(readFile().size() != 0)
		{
			ArrayList<ArrayList<String>> db = readFile();
			ArrayList<String> row = db.get(db.size() - 1);
		
			return (Integer.parseInt(row.get(0)) + 1);
		}
		else
			return 1; //No elements in data file (empty file)
	}
}
