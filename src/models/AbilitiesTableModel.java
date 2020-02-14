package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import internal.classes.Ability;

@SuppressWarnings("serial")
public class AbilitiesTableModel extends AbstractTableModel 
{
	protected static final String[] COLUMN_NAME_STRINGS = { "Name", "Required level" };
	private ArrayList<Ability> abilities;
	
	public AbilitiesTableModel(ArrayList<Ability> data)
	{
		updateData(data);
	}
	
	private void updateData(ArrayList<Ability> data)
	{
		this.abilities = data;
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
		return abilities.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Ability row = abilities.get(rowIndex);
		Object valueObject = null;
		
		switch (columnIndex) 
		{
			case 0:
				valueObject = row.getAbName();
				break;
			case 1:
				valueObject = row.getLevRequired();
				break;
		}
		
		return valueObject;
	}

}
