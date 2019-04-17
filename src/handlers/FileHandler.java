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
	private String pathOfFile = ""; //path/to/file
	
	
	public FileHandler()
	{
		try
		{
			String path = SettingsHandler.retrieveProperty("SaveFilePath");
			if(path.contentEquals(""))
				intializeClass();
			else
				pathOfFile = path;	
		}
		catch(Exception e)
		{
			intializeClass();
		}
	}
	
	private void intializeClass()
	{
		int result = 0;
		if(!testFile(true))
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
		else
		{
			testFile(true);
		}
	}
	
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
	
	public String getFilePath()
	{
		return pathOfFile;
	}
	
	public ArrayList<ArrayList<String>> readFile() 
	{
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();		
		
		try
		{
			File file = new File(pathOfFile);
			List<String> list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
			for(String item : list)
			{

				ArrayList<String> y=new ArrayList<String>(Arrays.asList(item.split("\\|")));
				x.add(y);
			}			
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return x;
	}
	
	public ArrayList<String> search(int id) 
	{
		ArrayList<ArrayList<String>> x = readFile();
		if(x!=null)
			for (ArrayList<String> item : x)
			{
				if(item.indexOf(Integer.toString(id))!=-1)				
				{
					return item;
				}	
			}
		return null;
	}

	public boolean writeFile(int Id, String name, String type) 
	{
		String x = Integer.toString(Id) + "|" + name + "|" + type + "\n";
		ArrayList<String> flag=search(Id);
		if(flag==null)
		{
			try
			{
				FileWriter fw = new FileWriter(pathOfFile, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw);
				out.append(x);			
				out.close();
				
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
	
	public boolean delete(int id)
	{		
		ArrayList<ArrayList<String>> db = readFile();
		ArrayList<String> arraySearch = search(id);
		db.remove(arraySearch);	
		try
		{
			FileWriter fw = new FileWriter(pathOfFile, false);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    out.write("");
			for(ArrayList<String> row:db)
			{
				String x="";
				int i=0;
				int maxI=row.size()-1;
				for(String item:row)
				{
					x+=item;
					if(maxI>i)
						x+="|";
					i++;
				}
				out.append(x+"\n");			
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
	
	public int getLastID()
	{
		ArrayList<ArrayList<String>> db = readFile();
		ArrayList<String> row=db.get(db.size());
		
		return (Integer.parseInt(row.get(0))+1);
	}
}
