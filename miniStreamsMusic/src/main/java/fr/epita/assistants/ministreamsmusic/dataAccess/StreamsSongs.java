package fr.epita.assistants.ministreamsmusic.dataAccess;

import fr.epita.assistants.ministreamsmusic.data.Song;

import java.util.List;

public class StreamsSongs {
    public static List<String> getOlderArtists(List<Song> songs)
    {
        return songs.stream().filter(i -> i.getArtist().getAge() >= 30).map(i -> i.getArtist().getSurname()).distinct().limit(10).toList();
    }

    public static Integer getSumAges(List<Song> songs)
    {
        return songs.stream().filter(i -> i.getArtist().getAge() >= 20).mapToInt(i -> i.getArtist().getAge()).sum();
    }

    public static List<String> getMusics(List<Song> songs)
    {
        return songs.stream().filter(i -> i.getArtist().getName().toLowerCase().contains("an")).limit(10).map(i -> i.getName()).toList();
    }
}
