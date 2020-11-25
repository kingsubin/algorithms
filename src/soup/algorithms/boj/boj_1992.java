package soup.algorithms.boj;

import java.io.*;

public class boj_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        divideAndConquer(0, 0, N);

        System.out.println(sb.toString());
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
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
            sb.append(map[x][y]);
        } else {
            int newLength = length/2;

            sb.append('(');
            divideAndConquer(x, y, newLength);
            divideAndConquer(x, y + newLength, newLength);
            divideAndConquer(x + newLength, y, newLength);
            divideAndConquer(x + newLength, y + newLength, newLength);
            sb.append(')');
        }
    }
}
