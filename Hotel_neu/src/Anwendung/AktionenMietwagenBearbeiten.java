package Anwendung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.MainFrame;
import GUI.MietwagenBearbeiten;
import GUI.Start;

public class AktionenMietwagenBearbeiten implements ActionListener {

	public MietwagenBearbeiten wBearbeiten;

	public AktionenMietwagenBearbeiten(MietwagenBearbeiten w) {
		wBearbeiten = w;
	}

	// Button-Aktionen ausführen
	public void actionPerformed(ActionEvent e) {
		System.out.println("Aktion: " + e.getActionCommand());

		if (e.getActionCommand().equals("MBEARBEITENZURUECK")) {
			MainFrame.frame.getContentPane().setVisible(false);
			MainFrame.frame.setContentPane(new Start());
		}
	}

}
