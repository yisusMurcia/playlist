import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option;
        Playlist myPlaylist = new Playlist();
        Scanner scan = new Scanner(System.in);
        System.out.println("Biemvenido, crea tu playlist");

        do {
            System.out.println(
                    "Opción 1: Añadir canción\n" +
                    "Opción 2: Editar canción\n" +
                    "Opción 3: Eliminar canción\n" +
                    "Opción 4: Sorprendeme\n" +
                    "Opción 5: Ver canciones\n" +
                    "Opción 4: Cambiar nombre a la playlist\n" +
                    "\tOpción 0: Salir"
            );
            option = scan.nextInt();
            switch (option){
                case 1:
                    addSong(myPlaylist);
                    break;
                case 2:

                case 5:
                    myPlaylist.displaySongs();
                default :
                    System.out.println("Algo salió mal, intenta nuevamente");
                    break;
            }

        }while(option != 0);
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
                    "Option 1: Change name\n" +
                    "Option 2: Change artist\n" +
                    "Option 3: Change/set genre\n" +
                    "Option 4: Change/set year\n" +
                    "\tOption 0: Salir");
                option = scan.nextInt();
            }while(option != 0);
        }else{
            System.out.println("Not song find");
        }
    }
}