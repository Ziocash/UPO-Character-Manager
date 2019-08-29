package windows;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controllers.MainMenuController;
import models.TableModel;

public class CharacterCreationWindow
{
	private JFrame frame;
	private JScrollPane scrollPane = new JScrollPane();
	
	public CharacterCreationWindow()
	{
		initializeComponents();
	}

	private void initializeComponents()
	{
		frame = new JFrame();
		frame.setTitle("Characters Manager - Creazione personaggio");
		frame.setBounds(0, 0, 700, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	//private void initialize
}
