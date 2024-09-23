public class Song {
    private String name;
    private String artist;
    private String genre;
    private int year;

    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        genre = "unknown";
    }

    public Song(String name, String artist, String genre, int year) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public void display(){
        System.out.println("Song: " + name + " by: " + artist);
        if(!genre.equalsIgnoreCase("unknown")){
            System.out.println("\tGenre: " + genre);
        }
        if(year > 0){
            System.out.println("\tCreaten in: "+ year);
        }
    }
}
