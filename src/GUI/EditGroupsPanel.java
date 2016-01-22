package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


public class EditGroupsPanel extends MAINMainPanel {
	
	private JLabel editGroupsTitle;
	private JButton back;
	private JTree tree;
	private PopupMenu menu;
	
	public EditGroupsPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	
	public void setPanels() {
		
		editGroupsTitle = guihelper.setLabel("Gruppen bearbeiten", 36);
		TitlePanel.add(editGroupsTitle);
		back = guihelper.setButton("Zurück ins Menü");
		ButtonPanel.add(back);
		DefaultMutableTreeNode top =
		        new DefaultMutableTreeNode("Gruppen");
		tree = new JTree(top);
		dbhandler.getGroupsAndCreateTreeNodes(top);
		tree.setRootVisible(false);
		tree.expandPath(new TreePath(top.getPath()));
		JScrollPane treeView = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		treeView.setPreferredSize(new Dimension(580, 180));
		ActionPanel.add(treeView);
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if (tree.getSelectionPath() != null) {
						menu = new PopupMenu();
						menu.setPopupMenu(tree);
				        menu.show(e.getComponent(), e.getX(), e.getY());	
					}
					
				}
		    }	
		});
	}

	public void installListener(){
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, Frame.MAINPANEL);
			}
		});
	}
}
