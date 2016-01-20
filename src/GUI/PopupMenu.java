package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import diesisteinprojekt.DBHandler;
import diesisteinprojekt.Group;
import diesisteinprojekt.User;


public class PopupMenu extends JPopupMenu{
	JMenuItem deleteGroup;
	JMenuItem deleteUserFromGroup;
	JMenuItem addUserToGroup;
	JMenuItem bla;
	String elementLabel;
	String groupLabel;
	DBHandler dbhandler = new DBHandler();
	ArrayList<String> groups = new ArrayList<String>();
	
    public void setPopupMenu(JTree tree){
    	groups = dbhandler.getGroupNameList();
    
    	DefaultMutableTreeNode selectedElement 
    	=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
    	elementLabel = selectedElement.getUserObject().toString();
    	groupLabel = selectedElement.getParent().toString();
        deleteGroup = new JMenuItem("Gruppe '" + elementLabel + "' löschen ");
        deleteUserFromGroup = new JMenuItem("Teilnehmer '" + elementLabel + "' aus Gruppe entfernen");
        addUserToGroup = new JMenuItem("Teilnehmer zur Gruppe '" + elementLabel + "' hinzufügen");
        bla = new JMenuItem("bla");
    	if (groups.contains(elementLabel)) {
    		add(deleteGroup);
    		add(addUserToGroup);
    	}
    	else{
    		add(deleteUserFromGroup);
    		
    	}

    	popupListener(tree, selectedElement);
    }


    
    public void popupListener(final JTree tree, final DefaultMutableTreeNode selectedElement){
		deleteUserFromGroup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				 int dialogButton = JOptionPane.YES_NO_OPTION;
	                JOptionPane.showConfirmDialog (null, "Teilnehmer" + elementLabel + " unwiderruflich löschen?","Warning",dialogButton);

	                if(dialogButton == JOptionPane.YES_OPTION){ 

	                	dbhandler.deleteUserFromGroup(elementLabel, groupLabel);
	                	selectedElement.removeFromParent();
	                	DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
	                	model.reload();
	                
	               }
			}
		});
		
		
		deleteGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				JOptionPane.showConfirmDialog (null, "Gruppe" + elementLabel + " unwiderruflich löschen?","Warning",dialogButton);

                if(dialogButton == JOptionPane.YES_OPTION){ 
                	dbhandler.deleteGroup(elementLabel);
                	selectedElement.removeFromParent();
                	DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                	model.reload();
                	
                }

			}
		});
		/*addUserToGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					ArrayList<String> users = dbhandler.getUserNameList();
					Object[] options = users.toArray();
					Object bla = JOptionPane.showInputDialog(null, "user", "user", JOptionPane.QUESTION_MESSAGE, null, options, users);
                	DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                	model.reload();
                	
                }	
		});*/
    }
   }
    
			
		
