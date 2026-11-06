# Código antigo (antes da refatoração)

Versão original do sistema de playlist, antes da aplicação do padrão **Iterator**.

## Problemas

- O cliente depende de uma lista com acesso por índice e controla a posição do percurso.
- `getSongs()` expõe a coleção interna, permitindo que código externo a altere sem passar pelas operações da playlist.
- Mudar a estrutura de armazenamento ou a forma de percorrer as músicas obriga a revisar o código cliente.

## Song.java

```java
public class Song {

    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
```

## Playlist.java

```java
import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }
}
```

## Main.java

```java
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.addSong(new Song("First song"));
        playlist.addSong(new Song("Second song"));
        playlist.addSong(new Song("Third song"));

        List<Song> songs = playlist.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(songs.get(i).getTitle());
        }
    }
}
```
