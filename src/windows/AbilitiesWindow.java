package windows;

import java.awt.Component;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controllers.AbilityTableController;
import controllers.AbilityWindowController;
import handlers.AbilityHandler;
import internal.classes.Ability;
import models.AbilitiesTableModel;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

public class AbilitiesWindow extends Dialog 
{
	/**
	 * Window owner
	 */
	private JFrame owner;	
	
	private JPanel panel = new JPanel();
	private JTable table;
	private AbilityWindowController controller = new AbilityWindowController(this);
	private AbilityHandler abilityHandler = new AbilityHandler();
	private AbilityTableController tableController = new AbilityTableController(this);
	private JLabel lblName;
	private JLabel lblClass;
	private JLabel lblSpecialization;
	private JLabel lblAbilityPoints;
	private JTextPane descriptionPane;
	private ArrayList<Ability> abilities;
	private int ownedAbilityNumber = 0;
	private int[] ownedAbilities = new int[4];
	
	/**
	 * AbilitiesWindow constructor
	 */
	public AbilitiesWindow()
	{
		initializeComponents();
		setTitle("Character Manager - Abilities");
		setType(Type.POPUP);
		setCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDialogProperties(false, 500, 350, owner);
		dialog.getContentPane().add(panel);
		initializeLayout();
		initializeTable();
	}
	
	/**
	 * Shows the window and initializes variables
	 * @param character Selected character
	 */
	public void showDialog(internal.classes.Character character) 
	{
		abilities = abilityHandler.getCharacterAbility(character.getCharClass(), character.getCharSpec());
		AbilitiesTableModel model = new AbilitiesTableModel(abilities);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(tableController);
		lblName.setText(character.getName());
		lblClass.setText(character.getCharClass().name());
		lblSpecialization.setText(character.getCharSpec().replace("_", " "));
		lblAbilityPoints.setText(getAbilityPoint(character.getLevel()));
		showDialog();
	}
	
	/**
	 * 
	 * @param level
	 * @return
	 */
	private String getAbilityPoint(int level) 
	{
		if(level>0)
			level--;
		int point=1+(level/5);
		
		return Integer.toString(point);
	}

	/**
	 * 
	 * @return
	 */
	public int buyAbility()
	{
		if(table.getSelectedRow() > -1)
		{
			if(ownedAbilityNumber < Integer.parseInt(lblAbilityPoints.getText()))
			{
				ownedAbilities[ownedAbilityNumber++] = abilities.get(table.getSelectedRow()).getId();
				return 0;
			}
			else
				return 1;
		}
		return -1;
	}
	
	/**
	 * Table initialization method
	 */
	public void initializeTable()
	{
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

			if (preferredWidth >= maxWidth)
				break;
		}

		return preferredWidth + 20;
	}
	
	/**
	 * Calculates the width based on the column name
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
	 * @wbp.parser.entryPoint
	 */
	private void initializeLayout()
	{
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblName = new JLabel("CharacterName");
		
		JLabel lblDescription = new JLabel("Description:");
		
		descriptionPane = new JTextPane();
		descriptionPane.setEditable(false);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(controller);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(controller);
		
		lblClass = new JLabel("CharacterClass");
		
		lblSpecialization = new JLabel("CharacterSpecialization");
		
		lblAbilityPoints = new JLabel("AbilityPoints");
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(controller);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addGap(128))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblClass, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addGap(131))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblSpecialization, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addGap(83))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblAbilityPoints, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addGap(83))
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addComponent(descriptionPane, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addComponent(lblName)
							.addGap(7)
							.addComponent(lblClass)
							.addGap(7)
							.addComponent(lblSpecialization)
							.addGap(6)
							.addComponent(lblAbilityPoints)
							.addGap(18)
							.addComponent(lblDescription)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(descriptionPane, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
	}
	
	/**
	 * 
	 * @param index
	 */
	public void getDescription(int index)
	{
		Ability ability = abilities.get(index);
		descriptionPane.setText(ability.getDescription());
	}
	
	public String getCharacterAbilities()
	{		
		return abilityHandler.parseAbilities(ownedAbilities);
	}
}
