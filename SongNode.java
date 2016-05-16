package project4FINAL;


public class SongNode {
	
	private Song elem;
	private SongNode next;
	
	// constructors
	public SongNode(Song elem, SongNode next)
	{
		this.elem = elem;
		this.next = next;
	}
	
	public SongNode(Song elem)
	{
		this.elem = elem;
		next = null;
	}
	
	// getters
	public Song elem()
	{
		return elem;
	}
	
	public SongNode next()
	{
		return next;
	}
	
	// setters 
	public void setElem(Song el)
	{
		elem = el;
	}

	public void setNext(SongNode other)
	{
		next = other;
	}
	
}
