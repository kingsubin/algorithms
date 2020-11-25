package soup.algorithms.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj_2447 {
    static char[][] map;
    static int length;
    static Scanner sc = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        length = sc.nextInt();
        map = new char[length][length];

        func(0, 0, length);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void func(int x, int y, int length) {
        // base condition
        if (length == 1) return;

        if (length == 3) {
            for (int i = x; i < x + length; i++) {
                for (int j = y; j < y + length; j++) {
                    if (i == x + 1 && j == y + 1) map[i][j] = ' ';
                    else map[i][j] = '*';
                }
            }
        }

        // recursion
        int newLength = length/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    printSpace(x + newLength * i, y + newLength * j, newLength);
                } else {
                    func(x + newLength * i, y + newLength * j, newLength);
                }
            }
        }
    }

    static void printSpace(int x, int y, int length) {
        if (length == 1) return;

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                map[i][j] = ' ';
            }
        }
    }
}
