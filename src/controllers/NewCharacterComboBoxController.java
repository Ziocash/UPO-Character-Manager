package controllers;
import static java.lang.System.out;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations.MageType;
import internal.classes.CharacterSpecializations.RogueType;
import internal.classes.CharacterSpecializations.WarriorType;

public class NewCharacterComboBoxController implements ActionListener
{
	private JComboBox child;
	public NewCharacterComboBoxController(JComboBox child)
	{
		this.child = child;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case "comboBoxChanged":
				switch((CharacterClasses)((JComboBox)e.getSource()).getSelectedItem())
				{
					case MAGE:
						child.setModel(new DefaultComboBoxModel(MageType.values()));
						break;
					case WARRIOR:
						child.setModel(new DefaultComboBoxModel(WarriorType.values()));
						break;
					case ROGUE:
						child.setModel(new DefaultComboBoxModel(RogueType.values()));
						break;
				}
				break;
		}
	}

}
