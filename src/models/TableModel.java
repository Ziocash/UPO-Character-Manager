package models;

import java.util.ArrayList;
import handlers.FileHandler;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel
{
	protected static final String[] COLUMN_NAME_STRINGS = { "ID", "Name", "Level", "Strength", "Intelligence", "Dexterity", "Charisma", "Constitution", "Class", "Specialization" };
	
	private ArrayList<ArrayList<String>> characters;
	private FileHandler fh = new FileHandler();
	
	public TableModel()
	{		
		updateData();
	}
	
	public TableModel(ArrayList<ArrayList<String>> data)
	{
		updateData(data);
	}

	private void updateData()
	{
		this.characters = new ArrayList<ArrayList<String>>(fh.getDb());
	}
	
	private void updateData(ArrayList<ArrayList<String>> data)
	{
		this.characters = data;
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
