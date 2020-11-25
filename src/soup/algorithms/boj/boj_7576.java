package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Dot> q = new LinkedList<>();
    static int[][] a, day;
    static boolean[][] v;
    static int row, col, nx, ny;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        v = new boolean[row][col];
        a = new int[row][col];
        day = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                day[i][j] = a[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!v[i][j] && a[i][j] == 1) { // start point check
                    v[i][j] = true;
                    q.offer(new Dot(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Dot d = q.poll();

            for (int k = 0; k < 4; k++) {
                nx = d.x + dx[k];
                ny = d.y + dy[k];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }

                if (!v[nx][ny] && a[nx][ny] == 0) {
                    v[nx][ny] = true;
                    day[nx][ny] = day[d.x][d.y] + 1;
                    q.offer(new Dot(nx, ny));
                }
            }
        }

        boolean flag = false;
        int max = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < day[i][j]) {
                    max = day[i][j];
                }
                if (day[i][j] == 0) {
                    flag = true;
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else {
            if (max - 1 == 0) {
                System.out.println(0);
            } else {
                System.out.println(max-1);
            }
        }


    }
}

class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}