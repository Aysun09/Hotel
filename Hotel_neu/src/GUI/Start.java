package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Start extends JPanel {

	JPanel screenPanel = new JPanel();

	public Start() {

		screenPanel = new JPanel();
		screenPanel.setBackground(Color.white);
		screenPanel.setPreferredSize(new Dimension(1000, 700));
		this.add(screenPanel);
		screenPanel.setVisible(true);

		// Logo einfügen
		JLabel logo = new JLabel(new ImageIcon("C:/Users/Aysun/Firmenlogo.png"));
		screenPanel.add(logo);

	}

}
