package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import GUI.MainFrame;
import GUI.Start;
import GUI.ZimmerBearbeiten;

public class AktionenZimmerBearbeiten implements ActionListener {

	public ZimmerBearbeiten zBearbeiten;

	public AktionenZimmerBearbeiten(ZimmerBearbeiten z) {
		zBearbeiten = z;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("ZBEARBEITENZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}

	}

}
