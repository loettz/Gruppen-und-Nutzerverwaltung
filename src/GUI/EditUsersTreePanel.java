package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import diesisteinprojekt.DBHandler;

public class EditUsersTreePanel extends JPanel{
	private DBHandler dbhandler = new DBHandler();
	private GUIHelper guihelper = new GUIHelper();
	private JTree tree;
	private JLabel editExistingUsers;
	private JCheckBox cbAll;
	private JCheckBox cbWithGroup;
	private JCheckBox cbWithoutGroup;
	public Font font = new Font("Source Sans Pro", Font.PLAIN, 12);
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
		
		add(editExistingUsers);
		add(cbAll);
		add(cbWithGroup);
		add(cbWithoutGroup);
		add(treeView);
		
	}

}
