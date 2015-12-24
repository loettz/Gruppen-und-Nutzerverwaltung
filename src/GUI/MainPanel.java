package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends MAINMainPanel{
	
	private JLabel menuTitle;
	
	private JButton createUserButton;
	private JButton createGroupButton;
	private JButton showGroupsButton;
	
	public MainPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	
	}
	
	public void setPanels() {
		
		menuTitle = guihelper.setLabel("Hauptmenü", 36);
		TitlePanel.add(menuTitle);
		createUserButton = guihelper.setButton("Teilnehmer erstellen");
		createGroupButton = guihelper.setButton("Gruppe erstellen");
		showGroupsButton = guihelper.setButton("Gruppen anzeigen");
		ButtonPanel.add(createUserButton);
		ButtonPanel.add(createGroupButton);
		ButtonPanel.add(showGroupsButton);
		
	}
		

		public void installListener(){
			createUserButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, Frame.CREATEUSER);
				}
			});
			createGroupButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, Frame.CREATEGROUP);
				}
			});
			showGroupsButton.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent arg0) {
			
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, Frame.SHOWGROUPS);
			}
			});}
}
