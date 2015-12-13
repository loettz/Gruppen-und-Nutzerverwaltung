package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MAINMainPanel extends JPanel{

	protected JPanel TitlePanel = new JPanel();
	protected JPanel ButtonPanel = new JPanel();
	protected JPanel ActionPanel = new JPanel();
	protected JLabel TitleLabel = new JLabel();
	
	private GUIHelper guihelper = new GUIHelper();
	
	public MAINMainPanel() {
		createMAINMainPanel();
	}
	
	public void createMAINMainPanel() {
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		add(TitlePanel);
		add(ButtonPanel);
		add(ActionPanel);
		setVisible(true);
}
}
