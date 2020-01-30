package windows;

import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.SettingsController;
import handlers.SettingsHandler;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.SystemColor;

public class SettingsWindow extends Dialog
{
	private JPanel panel = new JPanel();
	private JTextField textCharPath;
	private JTextField textAbilitiesPath;
	private SettingsController controller = new SettingsController(this);
	
	public SettingsWindow()
	{
		initializeComponents();
		setTitle("Characters Manager - Settings");
		setType(Type.UTILITY);
		setCloseOperation(JFrame.HIDE_ON_CLOSE);
		setDialogProperties(false, 500, 250, null);
		dialog.getContentPane().add(panel);
		initializeLayout();
		updateData();
	}

	public void updateData()
	{
		textCharPath.setText(SettingsHandler.retrieveProperty("SaveFilePath"));
		textAbilitiesPath.setText(SettingsHandler.retrieveProperty("AbilitiesFilePath"));
	}

	private void initializeLayout()
	{
		JLabel lblSavesPath = new JLabel("Characters path:", SwingConstants.RIGHT);
		
		JLabel lblTitle = new JLabel("Settings", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		textCharPath = new JTextField();
		textCharPath.setBackground(SystemColor.text);
		textCharPath.setEditable(false);
		textCharPath.setColumns(10);
		
		JButton btnBrowseCharFile = new JButton("Browse...");
		btnBrowseCharFile.setName("btnBrowseCharFile");
		btnBrowseCharFile.addActionListener(controller);
		
		JLabel lblAbilitiesFilePath = new JLabel("Abilities path:", SwingConstants.RIGHT);
		
		textAbilitiesPath = new JTextField();
		textAbilitiesPath.setBackground(SystemColor.text);
		textAbilitiesPath.setEditable(false);
		textAbilitiesPath.setColumns(10);
		
		JButton btnBrowseAbilitiesFile = new JButton("Browse...");
		btnBrowseAbilitiesFile.setName("btnBrowseAbilitiesFile");
		btnBrowseAbilitiesFile.addActionListener(controller);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(controller);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSavesPath, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textCharPath, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBrowseCharFile, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(119)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAbilitiesFilePath, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textAbilitiesPath, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBrowseAbilitiesFile, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(383, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSavesPath)
						.addComponent(textCharPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowseCharFile))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbilitiesFilePath)
						.addComponent(textAbilitiesPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowseAbilitiesFile, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
