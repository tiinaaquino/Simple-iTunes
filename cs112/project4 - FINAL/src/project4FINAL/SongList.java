package project4FINAL;

//import lab7.Link;

public class SongList {
	private SongNode head;
	private int size;

	public SongList() {
		head = null;
		size = 0;
	}

	// insert
	public void insert(Song newSong) {
		if (head == null) {
			head = new SongNode(newSong);
		} else {
			insertHelper(newSong);
		}
		size++;
	}

	// insert alaphabetically
	private void insertHelper(Song aSong) {
		SongNode parent = null;
		SongNode child = head;
		while (child != null && child.elem().compareTo(aSong) < 0) {
			parent = child;
			child = child.next();
		}
		if (parent == null) {
			SongNode node = new SongNode(aSong);
			node.setNext(child);
			head = node;
		} else {
			if (child == null) {
				SongNode newNode = new SongNode(aSong);
				parent.setNext(newNode);
			} else {
				SongNode other = new SongNode(aSong);
				parent.setNext(other);
				other.setNext(child);
			}
		}
	}

	public int size() {
		return size;
	}

	// find

	// print songs
	public void printSongs() {
		SongNode curr = head;
		while (curr.next() != null) {
			System.out.println(curr.elem() + " ");
			curr = curr.next();
		}
		System.out.println();
	}

}
