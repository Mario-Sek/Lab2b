package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = null;
    public static List<Song> songs = null;

    public static List<Album> albums = null;

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist(1L, "artist1", "ar1","aaaaa"));
        artists.add(new Artist(2L, "artist2", "ar2","bbbbb"));
        artists.add(new Artist(3L, "artist3", "ar3","ccccc"));
        artists.add(new Artist(4L, "artist4", "ar4","ddddd"));
        artists.add(new Artist(5L, "artist5", "ar5","eeeee"));

        albums = new ArrayList<>();
        albums.add(new Album("album 1", "pop", "2001"));
        albums.add(new Album("album 2", "rock", "2002"));
        albums.add(new Album("album 3", "metal", "2003"));
        albums.add(new Album("album 4", "jazz", "2004"));
        albums.add(new Album("album 5", "edm", "2005"));

        songs = new ArrayList<>();
        songs.add(new Song( "song1", "pop", 2001, albums.get(0)));
        songs.add(new Song( "song2", "rock", 2002, albums.get(1)));
        songs.add(new Song( "song3", "metal", 2003, albums.get(2)));
        songs.add(new Song("song4", "jazz", 2004, albums.get(3)));
        songs.add(new Song("song5", "edm", 2005, albums.get(4)));



    }
}
