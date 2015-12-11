package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowGroupsPanel extends MAINMainPanel {
	
	private JLabel showGroupsTitle;
	private JButton save;
	private JButton back;
	
	private Frame frame;
	private CardLayoutPanel cards;
	
	private GUIHelper guihelper = new GUIHelper();
	
	public ShowGroupsPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
		setPanels();
		installListener();
	}
	public void setPanels() {
		
		showGroupsTitle = guihelper.setLabel("Gruppen anzeigen", 36);
		TitlePanel.add(showGroupsTitle);
		
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		ButtonPanel.add(save);
		ButtonPanel.add(back);
		
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
