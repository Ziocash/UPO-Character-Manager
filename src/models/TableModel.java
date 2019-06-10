package models;

import java.util.ArrayList;
import handlers.FileHandler;

import javax.swing.table.AbstractTableModel;
import static java.lang.System.out;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel
{
	protected static final String[] COLUMN_NAME_STRINGS = { "ID", "Name", "Level", "Strength", "Constitution", "Class", "Specialization" };
	
	private ArrayList<ArrayList<String>> characters;
	
	public TableModel()
	{
		FileHandler fh = new FileHandler();
		this.characters = new ArrayList<ArrayList<String>>(fh.readFile());
		out.println(getColumnName(1));
	}
	
	@Override
	public int getColumnCount()
	{		
		return COLUMN_NAME_STRINGS.length;
	}
	
	@Override
	public String getColumnName(int index) 
	{
		return COLUMN_NAME_STRINGS[index];
	}

	@Override
	public int getRowCount()
	{
		return characters.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		ArrayList<String> row = characters.get(rowIndex);
		Object valueObject = null;
		
		valueObject = row.get(columnIndex);
		
		return valueObject;
	}

	

}
