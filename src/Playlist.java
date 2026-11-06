import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Playlist implements SongCollection {

    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        Objects.requireNonNull(song, "A música não pode ser nula.");
        songs.add(song);
    }

    @Override
    public SongIterator createIterator() {
        return new PlaylistIterator();
    }

    private class PlaylistIterator implements SongIterator {

        // Posição antes da primeira música disponível.
        private int position = -1;

        @Override
        public boolean hasNext() {
            return position + 1 < songs.size();
        }

        @Override
        public Song next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Não há mais músicas na playlist.");
            }
            position++;
            return songs.get(position);
        }
    }
}
