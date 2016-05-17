package project4FINAL;

public class SongDatabase {
	
	private SongList songs;
	//private String artist, songName;

	
	public SongDatabase()
	{
		songs = new SongList();
	}
	
	public void addSong(Song song)
	{
		songs.addSong(song);
	}
	

	public SongList getSongList()
	{
		return songs; 
	}
	
	public Song getSong(int index) {
		return songs.getSong(index);
	}
	
	public void setSongList(SongList songList) {
		this.songs = songList;
	}
	
	public SongList search(String title) {
		return songs.search(title);
	}
}
