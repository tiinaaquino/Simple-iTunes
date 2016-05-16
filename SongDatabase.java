package project4FINAL;

public class SongDatabase {
	
	private SongList list;
	private String artist, songName;
	
	
	
	// Should store private SongList songs
	// Other variables and methods
	// FILL IN CODE

	
	public SongDatabase()
	{
		list = new SongList();
	}
	
	public void addSong(Song song)
	{
		list.insert(song);
	}
	

	public SongList getSongList()
	{
		return list; 
	}

	
	
	
	// insert by title
	
	// find
	
	// search
	
	// boolean findSong
	
	// play
	
	//???? create inner class 
}
