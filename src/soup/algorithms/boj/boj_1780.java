package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_1780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        divideAndConquer(0, 0, N);

        for (int value : cnt) {
            System.out.println(value);
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt = new int[3]; // 0, 1, 2

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }
    }

    static boolean isSame(int x, int y, int length) {
        int val = map[x][y];

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (val != map[i][j]) return false;
            }
        }
        return true;
    }

    static void divideAndConquer(int x, int y, int length) {
        if (isSame(x, y, length)) {
            cnt[map[x][y]]++;
        } else {
            int newLength = length / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideAndConquer(x + newLength * i,y + newLength * j, newLength);
                }
            }
        }
    }
}
