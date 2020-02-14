package controllers;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import windows.AbilitiesWindow;
import windows.Dialog;

public class AbilityTableController implements ListSelectionListener 
{
	private Dialog dialog;

	public AbilityTableController(windows.Dialog dialog) 
	{
		this.dialog = dialog;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) 
        {
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) 
                if (lsm.isSelectedIndex(i)) 
                    ((AbilitiesWindow)dialog).getDescription(i);
        }
	}

}
