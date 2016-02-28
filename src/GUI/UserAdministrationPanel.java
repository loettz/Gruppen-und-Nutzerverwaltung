package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserAdministrationPanel extends MAINMainPanel{
	private JLabel userAdministrationTitle;
	private JButton createUser;
	private JButton back;
	protected EditUsersTreePanel treePanel;
	private JPanel menuPanel;
	protected CLUserAdministrationPanel clCards;
	
	public UserAdministrationPanel(Frame frame, MainCardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	public void setPanels() {
		userAdministrationTitle = guihelper.setLabel("Teilnehmerverwaltung", 36);
		createUser = guihelper.setButton("Teilnehmer erstellen");
		createUser.setPreferredSize(new Dimension(200, 25));
		back = guihelper.setButton("Zurück ins Menü");
		back.setPreferredSize(new Dimension(200, 25));
		TitlePanel.add(userAdministrationTitle);
		treePanel = new EditUsersTreePanel();
		menuPanel = guihelper.setPanel();
		ButtonPanel.setLayout(new GridLayout(1, 2));
		
		menuPanel.add(createUser);
		menuPanel.add(back);
		ButtonPanel.add(treePanel);
		ButtonPanel.add(menuPanel);
		
		clCards = new CLUserAdministrationPanel();
		ActionPanel.add(clCards);
	}

	public void installListener() {
			back.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					CardLayout clMain = (CardLayout)(cards.getLayout());
					clMain.show(cards, Frame.MAINPANEL);
					CardLayout cl = (CardLayout)(clCards.getLayout());
					cl.show(clCards, Frame.EMPTY);

				}
			});
			createUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					CardLayout cl = (CardLayout)(clCards.getLayout());
					cl.show(clCards, Frame.CREATEUSER);
				}
			});
		
	}
}


