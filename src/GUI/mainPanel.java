package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainPanel extends JPanel{
	
	private JPanel mainTitlePanel;
	private JPanel mainButtonPanel;
	private JPanel mainActionPanel;
	
	private JButton createUserButton;
	private JButton createGroupButton;
	private JButton showGroupsButton;
	
	private Frame frame;
	private cardLayoutPanel cards;
	private GUIHelper guihelper = new GUIHelper();
	
	public mainPanel(Frame frame, cardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
		createMainPanel();
		installListener();
	}
	
	public void createMainPanel() {
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		setVisible(true);
		
		mainTitlePanel = guihelper.setPanel();
		JLabel menuTitle = guihelper.setLabel("Hauptmenü", 36);
		mainTitlePanel.add(menuTitle);
		
		mainButtonPanel = guihelper.setPanel();
		createUserButton = guihelper.setButton("Teilnehmer erstellen");
		createGroupButton = guihelper.setButton("Gruppe erstellen");
		showGroupsButton = guihelper.setButton("Gruppen anzeigen");
		mainButtonPanel.add(createUserButton);
		mainButtonPanel.add(createGroupButton);
		mainButtonPanel.add(showGroupsButton);
		
		mainActionPanel = guihelper.setPanel();
		//brauch ich dieses Panel überhaupt? 
		
		add(mainTitlePanel);
		add(mainButtonPanel);
		add(mainActionPanel);
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
		});

	}
}
