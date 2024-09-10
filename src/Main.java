import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option;
        Playlist myPlaylist = new Playlist();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, now create your playlist");

        do {
            System.out.println(
                    """
                            Option 1: add song
                            Option 2: delete song
                            Option 3: sorprise me
                            Option 4: display songs
                            Option 5: change playlist´s name
                            \tOption 0: exit"""
            );
            option = scan.nextInt();
            switch (option){
                case 1:
                    addSong(myPlaylist);
                    break;
                case 2:
                    myPlaylist.removeSong(selectSong(myPlaylist));
                    break;
                case 3:
                    addPredeterminatedSongs(myPlaylist);
                    break;
                case 4:
                    myPlaylist.displaySongs();
                    break;
                case 5:
                    renamePlaylist(myPlaylist);
                    break;
                default:
                    System.out.println("Algo salió mal, intenta nuevamente");
                    break;
            }

        }while(option != 0);
        System.out.println("Exit... Thanks for use the program");
        scan.close();
    }

    private static void addSong(Playlist playlist){
        Scanner scan = new Scanner(System.in);
        String name;
        String artist;

        System.out.println("Enter the song´s name");
        name = scan.nextLine();

        System.out.println("Now, enter the song´s artist");
        artist = scan.nextLine();

        if (playlist.addSong(new Song(name, artist))){
            System.out.println("Your song is now in the playlist");
        }
    }

    private static Song selectSong(Playlist playlist){
        Scanner scan = new Scanner(System.in);

        playlist.displaySongs();
        System.out.println("Enter the name of the song");
        return playlist.getSong(scan.nextLine());
    }


    private static void addPredeterminatedSongs(Playlist playlist){
        playlist.addSong(new Song("Best of me", "Neffex"));
        playlist.addSong(new Song("The search", "NF"));
        playlist.addSong(new Song("Born for this", "The score"));
        playlist.addSong(new Song("When I die", "Kyle Hume"));
        playlist.addSong(new Song("Trauma", "BoyWithUKE"));
    }

    private static void renamePlaylist(Playlist playlist){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the new playlist´s name");
        playlist.setName(scan.nextLine());
    }
}