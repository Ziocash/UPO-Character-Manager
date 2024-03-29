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

public class NewCharacterController implements ActionListener
{
	@SuppressWarnings("rawtypes")
	private JComboBox child;
	private Dialog dialog;
	public NewCharacterController(Dialog dialog, @SuppressWarnings("rawtypes") JComboBox child)
	{
		this.child = child;
		this.dialog = dialog;
	}

	/**
	 * <h2>Input-based action</h2>
	 * <ul>
	 * <li>comboBoxChanged: combobox event when user changes selected value</li>
	 * <li>Create: creates a new character and closes the dialog</li>
	 * <li>Cancel: cancels the creation and closes the dialog</li>
	 * </ul>
	 */
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
