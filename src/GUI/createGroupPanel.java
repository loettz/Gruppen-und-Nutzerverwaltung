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

public class createGroupPanel extends JPanel{
	
	private JPanel createGroupTitlePanel;
	private JPanel createGroupButtonPanel;
	private JPanel createGroupActionPanel;
	private JLabel createGroupTitle;
	private JButton save;
	private JButton back;
	private JLabel groupSizeLabel;
	private JTextField groupSize;
	private JButton create;
	
	private Frame frame;
	private cardLayoutPanel cards;
	
	private GUIHelper guihelper = new GUIHelper();
	
	public createGroupPanel(Frame frame, cardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
		createGroup();
		installListener();
	}
	
	public void createGroup() {
		
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		setVisible(true);
		
		createGroupTitlePanel = guihelper.setPanel();
		createGroupTitle = guihelper.setLabel("Gruppe erstellen", 36);
		createGroupTitlePanel.add(createGroupTitle);
		
		createGroupButtonPanel = guihelper.setPanel();
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		createGroupButtonPanel.add(save);
		createGroupButtonPanel.add(back);
		
		createGroupActionPanel = guihelper.setPanelWithGrid(200, 400, 2, 1);
		groupSizeLabel = guihelper.setLabel("Anzahl Teilnehmer:", 14);
		groupSize = guihelper.setTextField();
		create = guihelper.setButton("Gruppe erstellen");
		createGroupActionPanel.add(groupSizeLabel);
		createGroupActionPanel.add(groupSize);
		createGroupActionPanel.add(create);
		
		add(createGroupTitlePanel);
		add(createGroupButtonPanel);
		add(createGroupActionPanel);
		

		
		
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
