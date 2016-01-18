package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
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
	String elementLabel;
	DBHandler dbhandler = new DBHandler();
	ArrayList<String> groups = new ArrayList<String>();
	
    public void setPopupMenu(JTree tree){
    	groups = dbhandler.getGroupNameList();
    
    	DefaultMutableTreeNode selectedElement 
    	=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
    	elementLabel = selectedElement.getUserObject().toString();
        deleteGroup = new JMenuItem("Gruppe '" + elementLabel + "' löschen ");
        deleteUserFromGroup = new JMenuItem("Teilnehmer '" + elementLabel + "' aus Gruppe entfernen");
        addUserToGroup = new JMenuItem("Teilnehmer zur Gruppe '" + elementLabel + "' hinzufügen");
    	if (groups.contains(elementLabel)) {
    		add(deleteGroup);
    		add(addUserToGroup);
    	}
    	else {
    		add(deleteUserFromGroup);
    	}

    }
}
