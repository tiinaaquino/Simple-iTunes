package project4FINAL;

//import lab7.Link;

public class SongList {
	private SongNode head, tail;
	
	public SongList()
	{
		head = null;
		tail = null;
	}
	
	//insert at front
	
	// insert
	public void insertOld(Song newSong)
	{
		SongNode curr = head;
		while (curr.next() != null)
		{
			
		}
	}
	
	public void insert(Song newSong) {
		SongNode newLink = new SongNode(newSong);
		if (tail != null) {
			tail.setNext(newLink);
			tail = newLink;
		} 
		else { // when the list is empty
			head =  tail = newLink;
		}
	}
	
	// find
	
	// is sorted
	
	// print songs
	public void printSongs()
	{
		SongNode curr = head;
		while (curr.next() != null)
		{
			System.out.println(curr.elem() + " ");
			curr = curr.next();
		}
		System.out.println();
	}
	
	
	
	

}
