package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class EditGroupsPanel extends MAINMainPanel {
	
	private JLabel editGroupsTitle;
	private JButton save;
	private JButton back;
	private JTree tree;

	
	public EditGroupsPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	
	
	public void setPanels() {
		
		editGroupsTitle = guihelper.setLabel("Gruppen bearbeiten", 36);
		TitlePanel.add(editGroupsTitle);
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		ButtonPanel.add(save);
		ButtonPanel.add(back);
		DefaultMutableTreeNode top =
		        new DefaultMutableTreeNode("Gruppen");
		//DefaultMutableTreeNode group = new DefaultMutableTreeNode("Gruppe1");
		tree = new JTree(top);
		dbhandler.getGroups(top);
		//top.add(group);
		JScrollPane treeView = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		treeView.setPreferredSize(new Dimension(580, 180));
		ActionPanel.add(treeView);

		
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
