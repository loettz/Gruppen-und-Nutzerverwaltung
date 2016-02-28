package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import diesisteinprojekt.DBHandler;

public class EditUsersTreePanel extends JPanel{
	//Panel with JTree for users in DB, checkboxes as filter
	private DBHandler dbhandler = new DBHandler();
	private GUIHelper guihelper = new GUIHelper();
	private JTree tree;
	private JLabel editExistingUsers;
	private JLabel filter;
	public JCheckBox cbAll;
	public JCheckBox cbWithGroup;
	public JCheckBox cbWithoutGroup;
	public Font font = new Font("Source Sans Pro", Font.PLAIN, 12);
	private EditUsersTreePopupMenu menu;
	DefaultMutableTreeNode top =
	        new DefaultMutableTreeNode("Teilnehmer");
	
	public EditUsersTreePanel() {
		super();
		createTreePanel();
		installListener();
		
	}
//TODO: JPopupMenu
	public void createTreePanel() {
		setBackground(Color.white);
		filter = guihelper.setLabel("Filter:", 14);
		editExistingUsers = guihelper.setLabel("bestehende Teilenhmer bearbeiten                ", 14);
		cbAll = guihelper.setCheckBox("Alle");
		cbAll.setSelected(true);
		cbWithGroup = guihelper.setCheckBox("mit Gruppe");
		cbWithoutGroup = guihelper.setCheckBox("ohne Gruppe");
		
		
		dbhandler.createAllUserNodes(top);
		tree = new JTree(top);
		tree.setRootVisible(false);
		tree.expandPath(new TreePath(top.getPath()));
		tree.setFont(font);
		final DefaultTreeCellRenderer renderer = 
		        (DefaultTreeCellRenderer)(tree.getCellRenderer());
		JScrollPane treeView = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		renderer.setTextNonSelectionColor(guihelper.colorZwei);
		renderer.setTextSelectionColor(Color.BLACK);
		treeView.setPreferredSize(new Dimension(290, 120));
		
		add(editExistingUsers);
		add(filter);
		add(cbAll);
		add(cbWithGroup);
		add(cbWithoutGroup);
		add(treeView);
		
	}
		
		public void installListener() {
			final DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
			cbAll.addItemListener(new ItemListener() {
				//its not allowed to select more than one checkbox contemporaneous
				//if a user selects a different checkbox all nodes are removed from tree 
				//and new nodes based on selection are added
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (cbWithGroup.isSelected()) {
							cbWithGroup.setSelected(false);
						}
						if (cbWithoutGroup.isSelected()) {
							cbWithoutGroup.setSelected(false);
						}
						
						while (top.getChildCount() != 0) {
							model.removeNodeFromParent(top.getFirstLeaf());
						}
						dbhandler.createAllUserNodes(top);
						model.reload();
				
					} else {
						while (top.getChildCount() != 0) {
							model.removeNodeFromParent(top.getFirstLeaf());
						}
						model.reload();
						}
					
				}
				
			});
			
			cbWithGroup.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (cbAll.isSelected()) {
							cbAll.setSelected(false);
						}
						if (cbWithoutGroup.isSelected()) {
							cbWithoutGroup.setSelected(false);
						}
						while (top.getChildCount() != 0) {
							model.removeNodeFromParent(top.getFirstLeaf());
						}
						
						dbhandler.createUserWithGroupNodes(top);
						model.reload();
				
					} else {
						while (top.getChildCount() != 0) {
							model.removeNodeFromParent(top.getFirstLeaf());
						}
						model.reload();
						}
						
					}
					
			});
			
			cbWithoutGroup.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						if (cbAll.isSelected()) {
							cbAll.setSelected(false);
						}
						if (cbWithGroup.isSelected()) {
							cbWithGroup.setSelected(false);
						}
						while (top.getChildCount() != 0) {
							model.removeNodeFromParent(top.getFirstLeaf());
						}
						dbhandler.createUserWithoutGroupNodes(top);
						model.reload();
		
				
					} else {
						while (top.getChildCount() != 0) {
							model.removeNodeFromParent(top.getFirstLeaf());
						}
						model.reload();
						}
				}
				
			});
			
			tree.addMouseListener(new MouseAdapter() {
				//Popupmenu shows up when right mousebutton is clicked
				public void mouseClicked(MouseEvent e) {
					if (SwingUtilities.isRightMouseButton(e)) {
						if (tree.getSelectionPath() != null) {
							menu = new EditUsersTreePopupMenu();
							menu.setPopupMenu(tree);
					        menu.show(e.getComponent(), e.getX(), e.getY());	
						}
						
					}
			    }	
			});
					
		
	}

}
