package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainPanel extends JPanel{
	
	private JPanel mainTitlePanel;
	private JPanel mainButtonPanel;
	private JPanel mainActionPanel;
	private GUIHelper guihelper = new GUIHelper();
	
	public mainPanel() {
		createMainPanel();
	}
	
	public void createMainPanel() {
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		setVisible(true);
		
		mainTitlePanel = guihelper.setPanel();
		JLabel menuTitle = guihelper.setLabel("Hauptmenü", 36);
		mainTitlePanel.add(menuTitle);
		
		mainButtonPanel = guihelper.setPanel();
		JButton createUserButton = guihelper.setButton("Teilnehmer erstellen");
		JButton createGroupButton = guihelper.setButton("Gruppe erstellen");
		JButton showGroupsButton = guihelper.setButton("Gruppen anzeigen");
		mainButtonPanel.add(createUserButton);
		mainButtonPanel.add(createGroupButton);
		mainButtonPanel.add(showGroupsButton);
		
		mainActionPanel = guihelper.setPanel();
		//brauch ich dieses Panel überhaupt? 
		
		add(mainTitlePanel);
		add(mainButtonPanel);
		add(mainActionPanel);
	}
}
