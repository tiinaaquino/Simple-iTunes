package project4FINAL;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class SongUtility {

	public static void addToDatabase(Path path, String pattern, SongDatabase songDatabase) {
		Finder finder = new Finder(pattern, songDatabase);
		try {
			Files.walkFileTree(path, finder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class Finder extends SimpleFileVisitor<Path> {
		private String pattern;
		private SongDatabase songDatabase;

		public Finder(String pattern, SongDatabase songDatabase) {
			this.pattern = pattern;
			this.songDatabase = songDatabase;
		}

		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
			findFile(path);
			return FileVisitResult.CONTINUE;
		}

		private void findFile(Path path) {
			String filename = path.toString();
			if (filename.contains(pattern)) {
				Song song = createSong(path);
				songDatabase.addSong(song);
			}
		}

		private Song createSong(Path path) {
			Song song = null;
			try {
				AudioFile audioFile = AudioFileIO.read(path.toFile());
				Tag tag = audioFile.getTag();
				String title = tag.getFirst(FieldKey.TITLE);
				String artist = tag.getFirst(FieldKey.ARTIST);
				String filename = path.toString();
				song = new Song(title, artist, filename);
			} catch (CannotReadException | IOException | TagException | ReadOnlyFileException
					| InvalidAudioFrameException e) {
				e.printStackTrace();
			}
			return song;
		}
	}
}

