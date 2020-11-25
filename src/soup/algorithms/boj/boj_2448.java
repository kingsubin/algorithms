package soup.algorithms.boj;

import java.io.*;
import java.util.Scanner;

public class boj_2448 {
    static Scanner sc = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] map;
    static int[] mapColSizes = new int[11];
    static int N, k, mapColSize;

    public static void main(String[] args) throws IOException {
        makeMap();  
        printMap(0, 0, k);
        print();
    }

    static void makeMap() {
        N = sc.nextInt();
        int a = N / 3;
        while (a > 1) {
            k++;
            a /= 2;
        }

        mapColSizes[0] = 5; // k
        for (int i = 1; i <= k; i++) {
            mapColSizes[i] = (mapColSizes[i-1] * 2) + 1;
        }

        mapColSize = mapColSizes[k];
        map = new char[N][mapColSize];
    }

    static void printMap(int x, int y, int level) {
        // base condition
        if (level == 0) {
            colorMap(x, y);
            return;
        }

        // recursion
        int n = (int) (3 * (Math.pow(2, level)));
        printMap(x, y + n/2, level - 1);
        printMap(x + n/2, y, level - 1);
        printMap(x + n/2, y + mapColSizes[level]/2 + 1, level - 1);
    }

    static void colorMap(int x, int y) {
        map[x][y+2] = '*';
        map[x+1][y+1] = '*';
        map[x+1][y+3] = '*';
        map[x+2][y] = '*';
        map[x+2][y+1] = '*';
        map[x+2][y+2] = '*';
        map[x+2][y+3] = '*';
        map[x+2][y+4] = '*';
    }

    static void print() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < mapColSize; j++) {
                if (map[i][j] == '*') bw.append('*');
                else bw.append(' ');
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
