package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Array;

public class CreateGroupPanel extends MAINMainPanel{
	
	private JLabel createGroupTitle;
	private JButton save;
	private JButton back;
	private JLabel groupNameLabel;
	private JTextField groupName;
	private JLabel groupSizeLabel;
	private JButton groupSizeButton;
	private JButton create;
	private String groupSize;


	
	public CreateGroupPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	public void setPanels() {
		
		createGroupTitle = guihelper.setLabel("Gruppe erstellen", 36);
		TitlePanel.add(createGroupTitle);
		
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		ButtonPanel.add(save);
		ButtonPanel.add(back);
		
		ActionPanel.setLayout(new GridLayout(3, 3));
		groupNameLabel = guihelper.setLabel("Gruppenname: ", 14);
		groupName = guihelper.setTextField();
		groupSizeLabel = guihelper.setLabel("", 14);
		groupSizeButton = guihelper.setButton("Anzahl bestimmen");
		create = guihelper.setButton("Gruppe erstellen");
		ActionPanel.add(groupNameLabel);
		ActionPanel.add(groupName);
		ActionPanel.add(groupSizeButton);
		ActionPanel.add(groupSizeLabel);
		ActionPanel.add(create);
		
		
	}
	public void installListener(){
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, Frame.MAINPANEL);
			}
		});
		
		groupSizeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				groupSize = (String) JOptionPane.showInputDialog(null, "Die Anzahl der Teilenhemr kann hier bestimmt werden.", "Gruppengröße auswählen",
				        JOptionPane.QUESTION_MESSAGE, null, new String[] {"5", "6", "7", "8"}, "");
				groupSizeLabel.setText(groupSize);
			}
		});
		
	}

}
	