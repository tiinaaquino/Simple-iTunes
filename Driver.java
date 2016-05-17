package project4FINAL;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mp3 player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SongDatabase songs = new SongDatabase();
		MPlayerPanel panel = new MPlayerPanel(songs);
		panel.setPreferredSize(new Dimension(600,400));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}