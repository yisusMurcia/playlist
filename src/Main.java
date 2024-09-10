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
                    "Option 4: sorprise me\n" +
                    "Option 5: display songs\n" +
                    "Option 6: change playlist´s name\n" +
                    "\tOption 0: exit"
            );
            option = scan.nextInt();
            switch (option){
                case 1:
                    addSong(myPlaylist);
                    break;
                case 2:
                    editSong(selectSong(myPlaylist));
                    break;
                case 3:
                    myPlaylist.removeSong(selectSong(myPlaylist));
                    break;
                case 4:
                    addPredeterminatedSongs(myPlaylist);
                    break;
                case 5:
                    myPlaylist.displaySongs();
                    break;
                case 6:
                    renamePlaylist(myPlaylist);
                    break;
                default:
                    System.out.println("Algo salió mal, intenta nuevamente");
                    break;
            }

        }while(option != 0);
        System.out.println("Exit... Thanks for use the program");
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

    private  static void editSong(Song song){
        Scanner scan = new Scanner(System.in);
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
                        System.out.println("Enter the new name");
                        song.setName(scan.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter the artist");
                        song.setArtist(scan.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter genre");
                        song.setGenre(scan.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter year");
                        song.setYear(scan.nextInt());
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