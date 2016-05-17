package project4FINAL;

public class Song implements Comparable<Song>{
	
	private String title;
	private String artist;
	private String filename;
	
	// constructor
	public Song(String title, String artist, String filename) {
		this.title = title;
		this.artist = artist;
		this.filename = filename;
	}
	
	// getters
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getFilename() {
		return filename;
	}
	
	// setters
	public void setSongTitle(String songTitle) {
		title = songTitle;
	}
	
	public void setSongArtist(String songArtist) {
		artist = songArtist;
	}
	
	public void setSongFile(String file) {
		filename = file;
	}
	
	//String toString
	@Override
	public String toString()
	{
		return (title + " " + artist + " " +  filename);
	}

	@Override
	public int compareTo(Song o) {
		return this.title.compareTo(o.title);
	}
	
	public String[] songArray() {
		return new String[] {title, artist};
	}
}
