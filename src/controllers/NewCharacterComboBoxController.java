package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations.MageType;
import internal.classes.CharacterSpecializations.RogueType;
import internal.classes.CharacterSpecializations.WarriorType;
import windows.Dialog;
import windows.Dialog.DialogResult;

public class NewCharacterComboBoxController implements ActionListener
{
	@SuppressWarnings("rawtypes")
	private JComboBox child;
	private Dialog dialog;
	public NewCharacterComboBoxController(Dialog dialog, @SuppressWarnings("rawtypes") JComboBox child)
	{
		this.child = child;
		this.dialog = dialog;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			case "Create":
				dialog.setResult(DialogResult.OK);
				dialog.close();
				break;
			case "Cancel":
				dialog.setResult(DialogResult.CANCEL);
				dialog.close();
			default:
				dialog.setResult(DialogResult.CLOSED);
				break;
				
		}
	}

}
