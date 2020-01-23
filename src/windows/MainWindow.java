package windows;

import java.awt.Component;
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

	public MainWindow()
	{
		initializeComponents();
		setTitle("Characters Manager - Manage your characters");
		setType(Type.NORMAL);
		setCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFrameProperties(true, 700, 450, null);
		initializeMenu();
		initializeTable();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
	}
	
	public void updateData()
	{
		model = new TableModel();
		initializeTable();
		table.invalidate();
		table.repaint();
		table.revalidate();
	}
	
	public void updateData(ArrayList<ArrayList<String>> data)
	{
		model = new TableModel(data);
		initializeTable();
		table.invalidate();
		table.repaint();
		table.revalidate();
	}
	
	/**
	 * Initialize window menus
	 */
	private void initializeMenu()
	{
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		//
		JMenuItem mntmNewWindow = new JMenuItem("New character");
		mntmNewWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewWindow);
		
		mntmNewWindow.addActionListener(controller);
		
		//
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		//
		JMenuItem mntmDeleteItem = new JMenuItem("Delete");
		mntmDeleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mntmDeleteItem.addActionListener(controller);
		mnNewMenu.add(mntmDeleteItem);
		
		//
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnNewMenu.add(mntmExit);
		
		mntmExit.addActionListener(controller);
	}
	
	/**
	 * Table initialization method
	 */
	private void initializeTable()
	{
		table.setModel(model);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		for (int i = 0; i < table.getColumnCount(); i++)
		{
			int dataWidth = getColumnDataWidth(i);
			int headerWidth = getColumnHeaderWidth(i);
			table.getColumnModel().getColumn(i).setPreferredWidth(Math.max(dataWidth, headerWidth));
		}
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
}
