import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option;
        Playlist myPlaylist = new Playlist();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, now create your playlist");

        do {
            System.out.println(
                    "Option 1: add song\n" +
                    "Option 2: edit song\n" +
                    "Option 3: delete song\n" +
                    "Option 4: surprise me\n" +
                    "Option 5: display songs\n" +
                    "Option 6: change playlist´s name\n" +
                    "\tOption 0: exit"
            );
            option = scan.nextInt();
            switch (option){
                case 1:
                    addSong(myPlaylist, scan);
                    break;
                case 2:
                    editSong(selectSong(myPlaylist, scan), scan);
                    break;
                case 3:
                    myPlaylist.removeSong(selectSong(myPlaylist, scan));
                    break;
                case 4:
                    addPredeterminatedSongs(myPlaylist);
                    break;
                case 5:
                    myPlaylist.displaySongs();
                    break;
                case 6:
                    renamePlaylist(myPlaylist, scan);
                    break;
                default:
                    System.out.println("Algo salió mal, intenta nuevamente");
                    break;
            }

        }while(option != 0);
        System.out.println("Exit... Thanks for use the program");
        scan.close();
    }

    private static void addSong(Playlist playlist, Scanner scan){
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

    private static Song selectSong(Playlist playlist, Scanner scan){

        playlist.displaySongs();
        System.out.println("Enter the name of the song");
        scan.nextLine();
        return playlist.getSong(scan.nextLine());
    }

    private  static void editSong(Song song, Scanner scan){
        int option;

        if (song != null){
            do {
                System.out.println("Your song : ");
                song.display();

                System.out.println("Select an option:\n" +
                    "Option 1: change name\n" +
                    "Option 2: change artist\n" +
                    "Option 3: change/set genre\n" +
                    "Option 4: change/set year\n" +
                    "\tOption 0: Exit");
                option = scan.nextInt();
                switch (option){
                    case 1 :
                        setSongName(song, scan);
                        break;
                    case 2:
                        setSongArtist(song, scan);
                        break;
                    case 3:
                        setSongGenre(song, scan);
                        break;
                    case 4:
                        setSongYear(song, scan);
                        break;
                    default :
                        System.out.println("Something goes wrong, try again");
                        break;
                }
            }while(option != 0);
        }else{
            System.out.println("Not song find");
        }
    }

    private static void setSongName(Song song, Scanner scan){
        scan.nextLine();
        System.out.println("Enter the new song´s name:");
        song.setName(scan.nextLine());
    }

    private static void setSongArtist(Song song, Scanner scan){
        scan.nextLine();
        System.out.println("Enter the new song´s artist:");
        song.setArtist(scan.nextLine());
    }

    private static void setSongGenre(Song song, Scanner scan){
        scan.nextLine();
        System.out.println("Enter the new song´s genre:");
        song.setGenre(scan.nextLine());
    }

    private static void setSongYear(Song song, Scanner scan){
        scan.nextLine();
        System.out.println("Enter the new song´s year:");
        song.setYear(scan.nextInt());
    }

    private static void addPredeterminatedSongs(Playlist playlist){
        playlist.addSong(new Song("Best of me", "Neffex"));
        playlist.addSong(new Song("The search", "NF"));
        playlist.addSong(new Song("Born for this", "The score"));
        playlist.addSong(new Song("When I die", "Kyle Hume"));
        playlist.addSong(new Song("Trauma", "BoyWithUKE"));
    }

    private static void renamePlaylist(Playlist playlist, Scanner scan){
        System.out.println("Enter the new playlist´s name");
        playlist.setName(scan.nextLine());
    }
}