package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import diesisteinprojekt.DBHandler;

public class EditGroupsTreePanel extends JPanel{
	//Panel with JTree that contains nodes for all groups and childnodes for users in the group
	
	protected DBHandler dbhandler = new DBHandler();
	protected GUIHelper guihelper = new GUIHelper();
	private EditGroupsTreePopupMenu menu;
	private JTree tree;
	private JLabel editExistingGroups;
	public Font font = new Font("Source Sans Pro", Font.PLAIN, 12);
	DefaultMutableTreeNode top =
	        new DefaultMutableTreeNode("Gruppen");

	public EditGroupsTreePanel() {
		super();
		createTreePanel();
		installListener();
		
	}
	
	public void createTreePanel() {
		setBackground(Color.white);
		editExistingGroups = guihelper.setLabel("bestehende Gruppen bearbeiten", 14);
		dbhandler.getGroupsAndCreateTreeNodes(top);
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
		treeView.setPreferredSize(new Dimension(290, 160));
		
		add(editExistingGroups);
		add(treeView);
		
	}
	
	public void installListener() {
		tree.addMouseListener(new MouseAdapter() {
			//Popupmenu shows up when right mousebutton is clicked
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if (tree.getSelectionPath() != null) {
						menu = new EditGroupsTreePopupMenu();
						menu.setPopupMenu(tree);
				        menu.show(e.getComponent(), e.getX(), e.getY());	
					}
					
				}
		    }	
		});
		// TODO Auto-generated method stub
		
	}
}
