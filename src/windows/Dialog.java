package windows;

import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;

import javax.swing.JDialog;
import javax.swing.JFrame;

public abstract class Dialog
{
	/**
	 * 
	 */
	protected JDialog dialog;
	
	/**
	 * 
	 */
	protected JFrame owner;
	
	/**
	 * Dialog result values.<br>
	 * 
	 * Provides a description on which button/command has been used by user<br>
	 * Possible values:
	 * <ul>
	 * <li>OK: when user selects confirmation button</li>
	 * <li>CANCEL: when user selects cancel button</li>
	 * <li>CLOSED: when user simply closes the dialog</li>
	 * </ul>
	 */
	public enum DialogResult
	{
		/**
		 * 
		 */
		OK,
		/**
		 * 
		 */
		CANCEL,
		/**
		 * 
		 */
		CLOSED		
	}
	
	/**
	 * Dialog result value.<br>
	 * 
	 * Provides a description on which button/command has been used by user
	 */
	protected DialogResult result;
	
	protected void setCloseOperation(int onClose) 
	{
		dialog.setDefaultCloseOperation(onClose);
	}

	/**
	 * Sets dialog properties
	 * @param resizable resizable property
	 * @param width width value
	 * @param height height value
	 * @param owner owner
	 */
	protected void setDialogProperties(boolean resizable, int width, int height, JFrame owner) 
	{
		dialog.setBounds(0, 0, width, height);
		dialog.setResizable(resizable);
		dialog.setLocationRelativeTo(owner);
		this.owner = owner;
	}
	
	/**
	 * Sets window modality
	 * @param modType {@link java.awt.Dialog.ModalityType}
	 */
	protected void setModality(ModalityType modType)
	{
		dialog.setModalityType(modType);
	}
	
	protected void setTitle(String title)
	{
		dialog.setTitle(title);
	}
	
	/**
	 * Sets window type
	 * @param type {@link java.awt.Window.Type}
	 */
	protected void setType(Type type) 
	{
		dialog.setType(type);
	}
	
	/**
	 * Initializes components
	 */
	protected void initializeComponents()
	{
		dialog = new JDialog();
	}
	
	/**
	 * Returns the {@link DialogResult} value
	 * @return the {@link DialogResult} value
	 */
	public DialogResult getResult()
	{
		return result;
	}

	/**
	 * Sets the {@link DialogResult} value
	 * @param result {@link DialogResult}   
	 */
	public void setResult(DialogResult result)
	{
		this.result = result;
	}

	/**
	 * Shows the dialog
	 */
	public void show()
	{
		dialog.setModalityType(ModalityType.MODELESS);
		dialog.setVisible(true);
	}
	
	/**
	 * Show the dialog with {@link ModalityType} set on APPLICATION_MODAL
	 */
	public void showDialog()
	{
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setVisible(true);
	}
	
	/**
	 * Returns a boolean on window visibility 
	 * @return a boolean on window visibility
	 */
	public boolean isShown()
	{
		return dialog.isVisible();
	}
	
	/**
	 * Closes the dialog
	 */
	public void close()
	{
		dialog.setVisible(false);
		dialog.dispose();
	}
}
