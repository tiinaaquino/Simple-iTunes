package project4FINAL;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
*   The GUI Panel for the MPlayer project
*/

public class MPlayerPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private SongDatabase songDatabase; // the class that contains songs
	
	// panels
	JPanel topPanel, bottomPanel;
	JScrollPane centerPanel;
	Thread currThread = null;
	
	// buttons and search box
	JButton playButton, stopButton, exitButton, loadMp3Button;
	JTextField searchBox;
	JButton searchButton;
	
	int selectedSong = -1;
	JTable table = null;
	private final JFileChooser fc = new JFileChooser();
	
	MPlayerPanel(SongDatabase songCol) {
		this.songDatabase = songCol;
		this.setLayout(new BorderLayout());
		// Create panels: top, center, bottom
		
		// Create the top panel that has the Load mp3 button, the textfield and
		// the Search button to search for a song
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 4));
		
		// create buttons
		loadMp3Button = new JButton("Load mp3");
		searchBox = new JTextField(5);
		searchButton = new JButton("Search");
		exitButton = new JButton ("Exit");
		playButton = new JButton("Play");
		stopButton = new JButton("Stop");
		
		// add a listener for each button
		loadMp3Button.addActionListener(new ButtonListener());
		exitButton.addActionListener(new ButtonListener());
		playButton.addActionListener(new ButtonListener());
		stopButton.addActionListener(new ButtonListener());
		searchButton.addActionListener(new ButtonListener());
		
		// add buttons and the textfield to the top panel
		topPanel.add(loadMp3Button);
		topPanel.add(searchBox);
		topPanel.add(searchButton);
		
		this.add(topPanel, BorderLayout.NORTH); // add the top panel to this
												// panel (MPlayer panel)
		
		// create the button panel and add three buttons to it
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		bottomPanel.add(playButton);
		bottomPanel.add(stopButton);
		bottomPanel.add(exitButton);
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		// the panel in the center that shows mp3 songs
		centerPanel = new JScrollPane();
		this.add(centerPanel, BorderLayout.CENTER);
		
		// file chooser (opens another window that allows the user to select a folder with files)
		// Set the default directory to the current directory
		fc.setCurrentDirectory(new File("."));
	}
	
	/** An inner listener class for buttons**/
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == loadMp3Button) {
				System.out.println("Load mp3 button");
				
				// read all the mp3 files from mp3 directory
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setDialogTitle("Select a directory with mp3 songs");
				
				
				int returnVal = fc.showOpenDialog(MPlayerPanel.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File dir = fc.getSelectedFile();
					// dir is the directory with the mp3 files that the user
					// selected
					
					// FILL IN CODE
					// - Call the method that recursively traverses
					// this directory to find all .mp3 files
					//
					// - Extract tags, add songs to the SongDatabase and display
					// them in the table in the center panel

					DirectoryTransverser d = new DirectoryTransverser(songDatabase);
					d.printFilesAndFolders(dir.toPath());
					
					String columnNames[] = { "Title", "Artist" };
					//table = new JTable(columnNames);
					// ^ not sure if that's correct because will it open a new window?
					

					updateUI();

				}

			}
			else if (e.getSource() == playButton) {
				
				if (table == null)
					return;
				selectedSong = table.getSelectedRow();
				System.out.println("selected Song = " + selectedSong + " ");
				
				// FILL IN CODE
				// Find the selected song in the SongDatabase and play it
				
			} else if (e.getSource() == stopButton) {
				//FILL IN CODE: stop playing the song if its currently playing
			} else if (e.getSource() == exitButton) {
				System.exit(0);
			}
			
			else if (e.getSource() == searchButton) {
				// FILL IN CODE - When the user presses the Search button,
				// your program should show only the songs that start with the
				// search word
			}
			
			
		} // actionPerformed
	} // ButtonListener
	
}
