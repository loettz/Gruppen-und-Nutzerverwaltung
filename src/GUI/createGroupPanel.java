package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class createGroupPanel extends JPanel{
	
	private JPanel createGroupTitlePanel;
	private JPanel createGroupButtonPanel;
	private JPanel createGroupActionPanel;
	private GUIHelper guihelper = new GUIHelper();
	
	public createGroupPanel() {
		createGroup();
	}
	
	public void createGroup() {
		
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		setVisible(true);
		
		createGroupTitlePanel = guihelper.setPanel();
		JLabel createGroupTitle = guihelper.setLabel("Gruppe erstellen", 36);
		createGroupTitlePanel.add(createGroupTitle);
		
		createGroupButtonPanel = guihelper.setPanel();
		JButton save = guihelper.setButton("Speichern");
		JButton back = guihelper.setButton("Zurück ins Menü");
		createGroupButtonPanel.add(save);
		createGroupButtonPanel.add(back);
		
		createGroupActionPanel = guihelper.setPanelWithGrid(200, 400, 2, 1);
		JLabel groupSizeLabel = guihelper.setLabel("Anzahl Teilnehmer:", 14);
		JTextField groupSize = guihelper.setTextField();
		JButton create = guihelper.setButton("Gruppe erstellen");
		createGroupActionPanel.add(groupSizeLabel);
		createGroupActionPanel.add(groupSize);
		createGroupActionPanel.add(create);
		
		add(createGroupTitlePanel);
		add(createGroupButtonPanel);
		add(createGroupActionPanel);
		

		
		
	}

}
