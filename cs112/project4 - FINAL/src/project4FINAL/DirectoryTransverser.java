package project4FINAL;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

// this class will handle the user when accessing directories to load mp3s

public class DirectoryTransverser {
	
	
	private SongDatabase obj;
	
	public DirectoryTransverser(SongDatabase obj) {
		this.obj = obj;
	}
	
	/**
	 * Iterates over all the files and subdirectories in a given directory
	 * Prints the name of each file and subfolder to the console
	 * Does NOT go inside subdirectories.
	 */
	
	public void printFilesAndFolders(Path path) {
		/*
		try {
			DirectoryStream<Path> listing = Files.newDirectoryStream(path);
			for (Path file: listing) {
				if (!Files.isDirectory(file)){
					AudioFile f = AudioFileIO.read(new File(file.toString()));
					Tag tag = f.getTag();
					String artist = tag.getFirst(FieldKey.ARTIST);
					String title = tag.getFirst(FieldKey.TITLE);
					Song song = new Song(title, artist, file.toString());
					obj.addSong(song);
					System.out.println(file.getFileName());
				}
				else
					printFilesAndFolders(file);
			}
			listing.close();
		} catch (IOException | CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException e) {
			System.out.println("Could not get the list of files/subfolders inside this folder");
		}
	}
	*/
	
	
	
	// DirectoryListingExample
	
		if (!Files.isDirectory(path)) {
			System.out.println("Path is not a directory. ");
			return;
		}
		try {
			DirectoryStream<Path> listing = Files.newDirectoryStream(path);
			for (Path file: listing) {
				if (!Files.isDirectory(file)) {
					System.out.println(file.getFileName());
				}
				else
					printFilesAndFolders(file);
			}
			listing.close();
		} catch (IOException e) {
			System.out.println("Could not get the list of files/subfolders inside this folder");
		}
	
	}
	
	
	
	
	
	
	// don't think we need main method
	/*
	public static void main(String[] args) {
		Path path = Paths.get("MP3"); // Change this path to some directory path on your machine
		DirectoryTransverser.printFilesAndFolders(path);
	}
	*/
	
	
	
	
	// not sure if this method belongs in here
	/*
	public String getArtist(String songFile)
	{
		AudioFile f = AudioFileIO.read(new File(songFile));
		Tag tag = f.getTag();
		String artist = tag.getFirst(FieldKey.ARTIST);
		return artist;
	}
	*/
}