package project4FINAL;


public class Song implements Comparable<Song>{
	
	private String songTitle;
	private String songArtist;
	private String songFile;
	
	// constructor
	public Song(String songTitle, String songArtist, String songFile)
	{
		this.songTitle = songTitle;
		this.songArtist = songArtist;
		this.songFile = songFile;
	}
	
	// getters
	public String getSongTitle()
	{
		return songTitle;
	}
	
	public String getSongArtist()
	{
		return songArtist;
	}
	
	public String getSongFile()
	{
		return songFile;
	}
	
	// setters
	public void setSongTitle(String title)
	{
		songTitle = title;
	}
	
	public void setSongArtist(String artist)
	{
		songArtist = artist;
	}
	
	public void setSongFile(String file)
	{
		songFile = file;
	}
	
	//String toString
	public String toString()
	{
		return (songTitle + " " + songArtist + " " +  songFile);
	}

	@Override
	public int compareTo(Song o) {
		return this.songTitle.compareTo(o.songTitle);
	}
}
