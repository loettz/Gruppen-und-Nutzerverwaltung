package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import diesisteinprojekt.DBHandler;

public class EditUsersTreePanel extends JPanel{
	private DBHandler dbhandler = new DBHandler();
	private GUIHelper guihelper = new GUIHelper();
	private JTree tree;
	private JLabel editExistingUsers;
	public JCheckBox cbAll;
	public JCheckBox cbWithGroup;
	public JCheckBox cbWithoutGroup;
	public Font font = new Font("Source Sans Pro", Font.PLAIN, 12);
	public ItemEvent i;
	DefaultMutableTreeNode top =
	        new DefaultMutableTreeNode("Teilnehmer");
	
	public EditUsersTreePanel() {
		super();
		createTreePanel();
		
	}

	public void createTreePanel() {
		setBackground(Color.white);
		editExistingUsers = guihelper.setLabel("Filter:", 14);
		cbAll = guihelper.setCheckBox("Alle");
		cbAll.setSelected(true);
		cbWithGroup = guihelper.setCheckBox("mit Gruppe");
		cbWithoutGroup = guihelper.setCheckBox("ohne Gruppe");
		
		//TODO Checkbox Listener
		
		
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
		treeView.setPreferredSize(new Dimension(290, 140));
		final DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		add(editExistingUsers);
		add(cbAll);
		add(cbWithGroup);
		add(cbWithoutGroup);
		add(treeView);
		

		cbAll.addItemListener(new ItemListener() {
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
		
	}

}
