package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import diesisteinprojekt.DBHandler;

public class EditUsersTreePopupMenu extends JPopupMenu{
	
	JMenuItem deleteUser;
	String elementLabel;
	public Font font = new Font("Source Sans Pro", Font.PLAIN, 12);
	DBHandler dbhandler = new DBHandler();
	
	public void setPopupMenu(JTree tree){
		DefaultMutableTreeNode selectedElement 
    	=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		elementLabel = selectedElement.getUserObject().toString();
		deleteUser = new JMenuItem(elementLabel + " löschen");
		deleteUser.setFont(font);
		add(deleteUser);
		popupListener(tree, selectedElement);
	}
	
	public void popupListener(final JTree tree, final DefaultMutableTreeNode selectedElement) {
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int dialogButton = JOptionPane.YES_NO_OPTION;
	                JOptionPane.showConfirmDialog (null, elementLabel + " unwiderruflich löschen?","Warning",dialogButton);
	                if(dialogButton == JOptionPane.YES_OPTION){ 
	                	dbhandler.deleteUser(elementLabel);
	                	selectedElement.removeFromParent();
	                	DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
	                	model.reload();
	                }

			}
		});
	}

}
