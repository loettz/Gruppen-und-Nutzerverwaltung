package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GroupAdministrationPanel extends MAINMainPanel{
	
	private JLabel groupAdministrationTitle;
	protected EditGroupsTreePanel treePanel;
	private JButton createGroupRandom;
	private JButton createGroupManual;
	private JButton back;
	private JPanel menuPanel;
	protected CLGroupAdministrationPanel clCards;

	//private JPanel treePanel;

	
	public GroupAdministrationPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	public void setPanels() {
		
		groupAdministrationTitle = guihelper.setLabel("Gruppenverwaltung", 36);
		createGroupRandom = guihelper.setButton("Gruppe erstellen");
		createGroupRandom.setPreferredSize(new Dimension(200, 25));
		//createGroupManual.setPreferredSize(new Dimension(200, 25));
		back = guihelper.setButton("Zurück ins Menü");
		back.setPreferredSize(new Dimension(200, 25));
		TitlePanel.add(groupAdministrationTitle);
		treePanel = new EditGroupsTreePanel();
		menuPanel = guihelper.setPanel();
		ButtonPanel.setLayout(new GridLayout(1, 2));
		//tree = new EditGroupsTree();
		
		
		menuPanel.add(createGroupRandom);
		menuPanel.add(back);
		ButtonPanel.add(treePanel);
		ButtonPanel.add(menuPanel);
		
		//CreateGroupRandomPanel bla = new CreateGroupRandomPanel();
		clCards = new CLGroupAdministrationPanel();
		ActionPanel.add(clCards);
		
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void installListener() {
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, Frame.MAINPANEL);
			}
		});
		// TODO Auto-generated method stub
		
		createGroupRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)(clCards.getLayout());
				cl.show(clCards, Frame.CREATEGROUPRANDOM);
			}
		});
		
	}

}
