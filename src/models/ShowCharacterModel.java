package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ShowCharacterModel extends AbstractTableModel 
{
	protected static final String[] COLUMN_NAME_STRINGS = { "Name", "Value" };
	private ArrayList<ArrayList<String>> character;
	
	public ShowCharacterModel(ArrayList<ArrayList<String>> data)
	{
		updateData(data);
	}
	
	private void updateData(ArrayList<ArrayList<String>> data)
	{
		this.character = data;
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
		return character.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		ArrayList<String> row = character.get(rowIndex);
		Object valueObject = null;
		
		valueObject = row.get(columnIndex);
		
		return valueObject;
	}

}
