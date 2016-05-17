package project4FINAL;

import java.util.Iterator;

public class SongList implements Iterable<Song>{
	private SongNode head;
	private int size;

	public SongList() {
		size = 0;
	}

	// insert
	public void addSong(Song newSong) {
		if (head == null) {
			head = new SongNode(newSong);
		} else {
			addSongHelper(newSong);
		}
		size++;
	}
	
	public Song getSong(int index) {
		Song song = null;
		SongNode current = head;
		int count = 0;
		while (count != index) {
			current = current.next();
			count++;
		}
		// song = current.song;
		song = current.elem();
		return song;
	}
	
	public SongList search(String title) {
		SongList songs = new SongList();
		SongNode curr = head;
		while (curr != null) {
			// Song song = curr.song;
			Song song = curr.elem();
			if (song.getTitle().startsWith(title)) {
				songs.addSong(song);
			}
			curr = curr.next();
		}
		return songs;
	}

	// insert alphabetically
	private void addSongHelper(Song aSong) {
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SongNode currentSong = head;
		while (currentSong != null) {
			sb.append(currentSong.elem().toString() + "\n");
			currentSong = currentSong.next();
		}
		return sb.toString();
	}

	public int size() {
		return size;
	}

	public void printSongs() {
		SongNode curr = head;
		while (curr.next() != null) {
			System.out.println(curr.elem() + " ");
			curr = curr.next();
		}
		System.out.println();
	}
	
	/*
	private class SongNode { 
		SongNode next;
		Song song;
		
		public SongNode(Song song) {
			this.song = song;
		}
	}
	*/
	
	 @Override
	 public Iterator<Song> iterator() {
		 return new InOrder(this);
	 }
	 
	 private class InOrder implements Iterator<Song> {
		 private SongList list;
		 private int count;
		 
		 public InOrder(SongList list) {
			 count = 0;
			 this.list = list;
		 }
		 
		 @Override
		 public boolean hasNext() {
			 return count != list.size();
		 }
		 
		 @Override
		 public Song next() {
			 Song song = list.getSong(count);
			 count++;
			 return song;
		 }
	 }

}
