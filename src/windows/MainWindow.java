package windows;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controllers.Controller;
import models.TableModel;
import java.awt.Font;
import java.awt.Window.Type;
import java.util.ArrayList;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainWindow extends Window
{
	
	private JTable table = new JTable();
	private JMenuBar menuBar = new JMenuBar();
	private JScrollPane scrollPane = new JScrollPane(); 
	private TableModel model = new TableModel();
	private Controller controller = new Controller(this, frame);

	/**
	 * MainWindow initialization
	 */
	public MainWindow()
	{
		initializeComponents();
		setTitle("Characters Manager - Manage your characters");
		setType(Type.NORMAL);
		setCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFrameProperties(true, 700, 450, null);
		frame.setMinimumSize(new Dimension(650, 350));
		initializeMenu();
		initializeTable();
		frame.setJMenuBar(menuBar);		
		
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
	}
	
	/**
	 * Updates data values into the table
	 */
	public void updateData()
	{
		model = new TableModel();
		initializeTable();
		table.revalidate();
	}
	
	/**
	 * Updates data values into the table based on {@code data}
	 * @param data that needs to be loaded into table
	 */
	public void updateData(ArrayList<ArrayList<String>> data)
	{
		model = new TableModel(data);
		initializeTable();
		table.revalidate();
	}
	
	/**
	 * Initialize window menus
	 */
	private void initializeMenu()
	{
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		//
		JMenuItem mntmNewChar = new JMenuItem("New character");
		mntmNewChar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewChar);
		
		mntmNewChar.addActionListener(controller);
		mntmNewChar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		//
		JMenuItem mntmEdit = new JMenuItem("Edit character");
		mntmEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmEdit);
		
		mntmEdit.addActionListener(controller);
		mntmEdit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		//
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		//
		JMenuItem mntmDeleteItem = new JMenuItem("Delete");
		mntmDeleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmDeleteItem);
		
		mntmDeleteItem.addActionListener(controller);
		mntmDeleteItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		//
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnNewMenu.add(mntmExit);
		
		mntmExit.addActionListener(controller);
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		//-------------------------------------------------------------
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmSettings);
		
		mntmSettings.addActionListener(controller);
		mntmSettings.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	}
	
	/**
	 * Table initialization method
	 */
	private void initializeTable()
	{
		table.setModel(model);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
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
	 * @param column
	 * @return
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
	 * Get the selected row and calls a model deletion
	 */
	public void deleteRow() 
	{
		int index = table.getSelectedRow();
		if(index > -1)
			if(JOptionPane.showConfirmDialog(frame, "Do you wanna delete the selected character?") == JOptionPane.OK_OPTION)
			{
				model.removeIndex(index);
				table.revalidate();
			}
		
	}

	public ArrayList<ArrayList<String>> getRow() 
	{
		if(table.getSelectedRow() > -1)
		{
			ArrayList<ArrayList<String>> characterValues = new ArrayList<ArrayList<String>>();
			for(int j = 1; j < model.getColumnCount(); j++)
			{
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(model.getColumnName(j));
				temp.add(model.getValueAt(table.getSelectedRow(), j).toString());
				characterValues.add(temp);
			}
			return characterValues;
		}
		return null;
	}
	
	public int getSelectedRowIndex()
	{
		return table.getSelectedRow(); 
	}
}
