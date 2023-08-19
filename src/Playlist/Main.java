package Playlist;

import java.util.Scanner;

public class Main {
    static String[] songs = new String[10];
    static int songCount = 0;

    public static void main(String[] args) {
        playlistApp();
    }

    static void playlistApp() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to your playlist");
            System.out.println("1. Add song");
            System.out.println("2. Remove song");
            System.out.println("3. View playlist");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter song title: ");
                    sc.nextLine();
                    String songTitle = sc.nextLine();
                    addSong(songTitle);
                }
                case 2 -> {
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    removeSong(index);
                }
                case 3 -> viewPlaylist();
                case 4 -> System.out.println("Bye");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }

    static void addSong(String songTitle) {
        //validate
        if (songCount >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }
        // Add song to playlist
        songs[songCount] = songTitle;
        songCount++;
    }

    static void viewPlaylist() {
        for (int i = 0; i < songCount; i++) {
            System.out.println("Index: " + i + " - " + songs[i]);
        }
    }

    static void viewFullPlaylist() {
        for (int i = 0; i < songs.length; i++) {
            System.out.println("Index: " + i + " - " + songs[i]);
        }
    }

    static void removeSong(int index) {
        //validate empty
        if (songCount <= 0) {
            System.out.println("Playlist is empty");
            return;
        }

        //validate index
        if (index < 0 || index >= songCount) {
            System.out.println("Invalid index");
            return;
        }

        // Shift the song down
        for (int i = index; i < songCount - 1; i++) {
            songs[i] = songs[i + 1];
        }
        // Remove the duplicate song at the end
        songs[songCount - 1] = null;
        songCount--;
    }
}