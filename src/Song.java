public class Song {
    private final String name;
    private final String artist;
    private final String genre;

    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        genre = "unknown";
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public void display(){
        System.out.println("Song: " + name + " by: " + artist);
        if(!genre.equalsIgnoreCase("unknown")){
            System.out.println("\tGenre: " + genre);
        }
    }
}
