import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.addSong(new Song("First song"));
        playlist.addSong(new Song("Second song"));
        playlist.addSong(new Song("Third song"));

        SongCollection collection = playlist;

        System.out.println("=== Percurso completo ===");
        printAll(collection.createIterator());

        System.out.println();
        System.out.println("=== Iteradores independentes ===");
        SongIterator first = collection.createIterator();
        SongIterator second = collection.createIterator();
        first.next();
        System.out.println("Primeiro iterador (2º avanço): " + first.next().getTitle());
        System.out.println("Segundo iterador (1º avanço): " + second.next().getTitle());

        System.out.println();
        System.out.println("=== Playlist vazia ===");
        SongCollection empty = new Playlist();
        SongIterator emptyIterator = empty.createIterator();
        System.out.println("hasNext(): " + emptyIterator.hasNext());

        System.out.println();
        System.out.println("=== next() após o fim do percurso ===");
        SongIterator iterator = collection.createIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        try {
            iterator.next();
        } catch (NoSuchElementException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }

    private static void printAll(SongIterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}
