package jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard lotre = new LotreBoard();

        lotre.generateBoard();
        System.out.println("Selamat datang di E-Lottery PrizePool $9000");
        lotre.displayBoard();

        while (!lotre.isGameOver()) {
            System.out.print("\nMasukkan tebakan kamu (baris dan kolom) : ");
            int baris = scanner.nextInt();
            int kolom = scanner.nextInt();

            boolean aman = lotre.guess(baris, kolom);

            if (!aman) {
                System.out.println("BOOM! bruakakak kamu menemukan bom! Permainan berakhir");
                lotre.displayBoard();
                break;
            }

            if (lotre.isGameOver() && lotre.isMenang()) {
                System.out.println("Selamat kamu menang");
                lotre.displayBoard();
                break;
            }

            lotre.displayBoard();
        }

        scanner.close();
    }
}