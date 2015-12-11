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

public class CreateGroupPanel extends MAINMainPanel{
	
	private JLabel createGroupTitle;
	private JButton save;
	private JButton back;
	private JLabel groupSizeLabel;
	private JTextField groupSize;
	private JButton create;
	
	private Frame frame;
	private CardLayoutPanel cards;
	
	private GUIHelper guihelper = new GUIHelper();
	
	public CreateGroupPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
		setPanels();
		installListener();
	}
	public void setPanels() {
		
		createGroupTitle = guihelper.setLabel("Gruppe erstellen", 36);
		TitlePanel.add(createGroupTitle);
		
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		ButtonPanel.add(save);
		ButtonPanel.add(back);
		
		ActionPanel.setLayout(new GridLayout(2, 1));
		groupSizeLabel = guihelper.setLabel("Anzahl Teilnehmer:", 14);
		groupSize = guihelper.setTextField();
		create = guihelper.setButton("Gruppe erstellen");
		ActionPanel.add(groupSizeLabel);
		ActionPanel.add(groupSize);
		ActionPanel.add(create);
		
		
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
	