package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<int[]> q;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = { 0, 0, 1, -1, 1, -1, -1, 1 };
    static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };
    static int row, col, nx, ny;
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        input();

        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        if (!isEnd) {
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            if (col == 0 && row == 0) {
                isEnd = true;
                return;
            }

            map = new int[row][col];
            v = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
            input();
        }
    }

    static void solve() throws IOException {
        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!v[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    ans++;
                }
            }
        }

        bw.write(ans + "\n");
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();

        v[x][y] = true;
        q.offer(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (map[nx][ny] == 1 && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
