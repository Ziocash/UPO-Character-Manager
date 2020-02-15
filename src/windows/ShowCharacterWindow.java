package windows;

import java.awt.Font;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import internal.classes.Character;
import internal.classes.CharacterClasses;
import controllers.ShowCharacterController;
import handlers.CharacterHandler;
import models.ShowCharacterModel;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ShowCharacterWindow extends windows.Dialog
{
	/**
	 * Window owner
	 */
	private JFrame owner;	
	
	private JPanel panel = new JPanel();
	private JTable table;
	private ShowCharacterController controller = new ShowCharacterController(this);
	private JLabel lblCharacterName = new JLabel("Placeholder");
	private JLabel lblCharacterType = new JLabel("CharacterType");	
	private JLabel lblCharacterSpecialization = new JLabel("CharacterSpecialization");
	
	private CharacterHandler charHandler = new CharacterHandler();
	private Character character;

	/**
	 * ShowCharacterWindow constructor
	 */
	public ShowCharacterWindow()
	{
		initializeComponents();
		dialog.setTitle("Characters Manager - Edit character");
		setDialogProperties(true, 600, 400, owner);
		setType(Type.POPUP);
		setCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setContentPane(panel);
		initializePanel();
		
	}
	
	/**
	 * GUI initialization
	 */
	private void initializePanel() 
	{
		lblCharacterName.setVerticalAlignment(SwingConstants.TOP);
		lblCharacterName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLevelUp = new JButton("Level up");
		btnLevelUp.addActionListener(controller);
		
		JButton btnShowAbility = new JButton("Show ability");
		btnShowAbility.addActionListener(controller);
		
		JButton btnClose = new JButton("OK");
		btnClose.addActionListener(controller);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(controller);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCharacterSpecialization, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCharacterName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(184))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCharacterType, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnLevelUp, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnShowAbility, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
									.addContainerGap())))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(103)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblCharacterName)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnShowAbility)
							.addGap(18)
							.addComponent(btnLevelUp)
							.addGap(34)
							.addComponent(lblCharacterType)
							.addGap(18)
							.addComponent(lblCharacterSpecialization)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnClose)
								.addComponent(btnCancel))))
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
	}

	/**
	 * Loads data into a {@code Character} type value then loads table
	 * @param data Expected value {@code ArrayList<ArrayList<String>>}
	 */
	public void loadData(ArrayList<ArrayList<String>> data)
	{
		if(data != null)
		{
			character = new Character(0);
			character.setName(data.get(0).get(1));
			character.setLevel(Integer.parseInt(data.get(1).get(1)));
			character.setStrength(Double.parseDouble(data.get(2).get(1)));
			character.setIntelligence(Double.parseDouble(data.get(3).get(1)));
			character.setDexterity(Double.parseDouble(data.get(4).get(1)));
			character.setCharisma(Double.parseDouble(data.get(5).get(1)));
			character.setConstitution(Double.parseDouble(data.get(6).get(1)));
			character.setAbilities(data.get(7).get(1));
			character.setCharClass(CharacterClasses.valueOf(data.get(data.size()-2).get(1)));
			character.setCharSpec(data.get(data.size()-1).get(1).replace(' ', '_'));
			lblCharacterName.setText(data.get(0).get(1));
			lblCharacterName.setFont(new Font("Segoe UI", Font.BOLD, 18));
			lblCharacterType.setText("Character class: " + data.get(data.size()-2).get(1));
			lblCharacterSpecialization.setText("Character specialization: " + data.get(data.size()-1).get(1));
			
			data.remove(0);
			data.remove(data.size()-2);
			data.remove(data.size()-1);
			
			table.setModel(new ShowCharacterModel(data));
			initializeTable();
		}
	}
	
	/**
	 * Table initialization method
	 */
	private void initializeTable()
	{
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table.setEnabled(false);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		for (int i = 0; i < table.getColumnCount(); i++)
		{
			int dataWidth = getColumnDataWidth(i);
			int headerWidth = getColumnHeaderWidth(i);
			table.getColumnModel().getColumn(i).setPreferredWidth(Math.max(dataWidth, headerWidth));
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	
	/**
	 *  Calculates the width based on the widest cell renderer for the
	 *  given column.
	 */
	private int getColumnDataWidth(int column)
	{
		int preferredWidth = 0;
		int maxWidth = table.getColumnModel().getColumn(column).getMaxWidth();

		for (int row = 0; row < table.getRowCount(); row++)
		{
			preferredWidth = Math.max(preferredWidth, getCellDataWidth(row, column));

			//  We've exceeded the maximum width, no need to check other rows

			if (preferredWidth >= maxWidth)
				break;
		}

		return preferredWidth + 20;
	}
	
	/**
	 * Calculates the width based on the column name
	 * @param column
	 * @return
	 */
	private int getColumnHeaderWidth(int column)
	{
		TableColumn tableColumn = table.getColumnModel().getColumn(column);
		Object value = tableColumn.getHeaderValue();
		TableCellRenderer renderer = tableColumn.getHeaderRenderer();

		if (renderer == null)
		{
			renderer = table.getTableHeader().getDefaultRenderer();
		}

		Component c = renderer.getTableCellRendererComponent(table, value, false, false, -1, column);
		return c.getPreferredSize().width + 20;
	}
	
	/**
	 * Get the preferred width for the specified cell
	 * @param row
	 * @param column
	 * @return
	 */
	private int getCellDataWidth(int row, int column)
	{
		//  Invoke the renderer for the cell to calculate the preferred width

		TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		Component c = table.prepareRenderer(cellRenderer, row, column);
		int width = c.getPreferredSize().width + table.getIntercellSpacing().width;

		return width + 20;
	}
	
	/**
	 * 
	 */
	public void levelUp()
	{
		character.levelUp();		
		update();
	}

	/**
	 * 
	 * @return
	 */
	public String getEditedCharacter() 
	{
		if(character != null)
			return character.toFileString().replace("\n", "");
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Character getCharacter()
	{
		if(character != null)
			return character;
		return null;
	}
	
	public void update()
	{
		charHandler.delete(0);
		charHandler.addCharacter(character);
		models.TableModel model = new models.TableModel(charHandler.parseList());
		ArrayList<ArrayList<String>> characterValues = new ArrayList<ArrayList<String>>();
		for(int j = 1; j < model.getColumnCount(); j++)
		{
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(model.getColumnName(j));
			temp.add(model.getValueAt(0, j).toString());
			characterValues.add(temp);
		}
		loadData(characterValues);
	}
}
