package windows;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations.*;
import controllers.ButtonController;
import controllers.Controller;
import controllers.NewCharacterComboBoxController;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.util.ArrayList;

public class CharacterCreationWindow extends Dialog
{
	private JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbClass = new JComboBox();
	@SuppressWarnings("rawtypes")
	private JComboBox cmbSpec = new JComboBox();
	private NewCharacterComboBoxController controller;
	
	
	public CharacterCreationWindow()
	{
		initializeComponents();
		setTitle("Characters Manager - Create new character");
		setType(Type.UTILITY);
		setCloseOperation(JFrame.HIDE_ON_CLOSE);
		setDialogProperties(false, 473, 211, null);
		dialog.getContentPane().add(scrollPane);
		initializeLayout();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initializeLayout()
	{
		controller = new NewCharacterComboBoxController(this, cmbSpec);
		JLabel lblName = new JLabel("Name");
		JLabel lblClass = new JLabel("Class");		
		JLabel lblSpecialization = new JLabel("Specialization");
		
		cmbClass.addActionListener(controller);
		cmbClass.setModel(new DefaultComboBoxModel(CharacterClasses.values()));		
		
		switch((CharacterClasses)cmbClass.getSelectedItem())
		{
			case MAGE:
				cmbSpec.setModel(new DefaultComboBoxModel(MageType.values()));
				break;
			case WARRIOR:
				cmbSpec.setModel(new DefaultComboBoxModel(WarriorType.values()));
				break;
			case ROGUE:
				cmbSpec.setModel(new DefaultComboBoxModel(RogueType.values()));
				break;
		}
		
		JButton btnCreaPersonaggio = new JButton("Create");
		btnCreaPersonaggio.addActionListener(controller);
		
		JButton btnAnnulla = new JButton("Cancel");
		btnAnnulla.addActionListener(controller);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(dialog.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSpecialization, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnnulla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreaPersonaggio))
						.addComponent(textField, Alignment.LEADING)
						.addComponent(cmbClass, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cmbSpec, Alignment.LEADING, 0, 261, Short.MAX_VALUE))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClass)
						.addComponent(cmbClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpecialization)
						.addComponent(cmbSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreaPersonaggio)
						.addComponent(btnAnnulla))
					.addContainerGap())
		);
		dialog.getContentPane().setLayout(groupLayout);
		
	}

	public String getNewCharacter() 
	{
		String character = "";
		character += textField.getText() + "|";
		character += "1" + "|";
		character += "30" +"|";
		character += "30" +"|";
		character += "30" +"|";
		character += "30" +"|";
		character += "30" +"|";
		character += cmbClass.getSelectedItem().toString() + "|";
		character += cmbSpec.getSelectedItem().toString();
		
		return character;
	}
}
