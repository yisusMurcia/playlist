import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> playlistSongs;

    public Playlist(String name) {
        this.name = name;
        playlistSongs = new ArrayList<Song>();
    }
    public Playlist(){
        this.name = "My playlist";
        playlistSongs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displaySongs(){
        int numOfSongs = playlistSongs.size();
        System.out.println(name + " has " + numOfSongs + "Songs:");
        for (Song song : playlistSongs){
            song.display();
        }
        if(playlistSongs.size() != 0) { //Show the separetor only if there is one song
            System.out.println("\t\t------");
        }
    }

    public boolean addSong(Song song){
        //The song can´t be in the playlist
        for(Song playListSong : playlistSongs){
            if(playListSong.getName().equalsIgnoreCase(song.getName()) && playListSong.getArtist().equalsIgnoreCase(song.getArtist())){
                System.out.println("The song is in the playlist");
                return false;
            }
        }
        playlistSongs.add(song);
        return true;
    }

    public void removeSong(Song song){
        if(song != null && playlistSongs.remove(song)){
            System.out.println("The song has been removed");
        }else{
            System.out.println("Something goes wrong");
        }
    }

    public Song getSong(String name){
        for (Song playlistSong : playlistSongs){
            if(playlistSong.getName().equalsIgnoreCase(name)){
                return playlistSong;
            }
        }
        return null;
    }
}
