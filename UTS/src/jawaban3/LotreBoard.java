package jawaban3;

import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;

    private int kotakAmanTerbuka = 0;
    private boolean kenaBom = false;

    // inisialisasi papan
    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
            }
        }
    }

    // sebar 2 bom acak
    public void generateBoard() {
        Random rand = new Random();
        int jumlahBom = 0;

        while (jumlahBom < 2) {
            int baris = rand.nextInt(4);
            int kolom = rand.nextInt(5);

            if (data[baris][kolom] == 0) {
                data[baris][kolom] = 1; // 1 = bom
                jumlahBom++;
            }
        }
    }

    // cetak papan
    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // proses tebakan
    public boolean guess(int row, int col) {
        // cek batas
        if (row < 0 || row >= 4 || col < 0 || col >= 5) {
            System.out.println("Tebakan di luar batas papan!");
            return true;
        }

        // cek kotak sudah dibuka
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        // cek kena bom
        if (data[row][col] == 1) {
            board[row][col] = 'X';
            kenaBom = true;
            return false;
        } else {
            board[row][col] = 'O'; // O = aman
            kotakAmanTerbuka++;
            System.out.println("Kotak Aman");
            return true;
        }
    }

    // cek status selesai
    public boolean isGameOver() {
        return kenaBom || kotakAmanTerbuka == 18;
    }

    // cek status menang
    public boolean isMenang() {
        return kotakAmanTerbuka == 18 && !kenaBom;
    }
}