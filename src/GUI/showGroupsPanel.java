package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class showGroupsPanel extends JPanel{
	
	private JPanel showGroupTitlePanel;
	private JPanel showGroupButtonPanel;
	private JPanel showGroupActionPanel;
	private JLabel createGroupTitle;
	private JButton save;
	private JButton back;
	
	private Frame frame;
	private cardLayoutPanel cards;
	
	private GUIHelper guihelper = new GUIHelper();
	
	public showGroupsPanel(Frame frame, cardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
		showGroup();
		installListener();
	}
	
	public void showGroup() {
		
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		setVisible(true);
		
		showGroupTitlePanel = guihelper.setPanel();
		createGroupTitle = guihelper.setLabel("Gruppen anzeigen", 36);
		showGroupTitlePanel.add(createGroupTitle);
		
		showGroupButtonPanel = guihelper.setPanel();
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		showGroupButtonPanel.add(save);
		showGroupButtonPanel.add(back);
		
		showGroupActionPanel = guihelper.setPanel();
		// hier muss noch ne action rein
		
		add(showGroupTitlePanel);
		add(showGroupButtonPanel);
		add(showGroupActionPanel);
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
