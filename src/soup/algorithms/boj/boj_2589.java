package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int row, col, nx, ny, ans;
    static char[][] map;
    static int[][] max;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        max = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    static void bfs(int x, int y) {
        v = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        int distance = 0;

        v[x][y] = true;
        q.offer(new int[] {x, y, distance});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                distance = now[2];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (map[nx][ny] == 'L' && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, distance + 1});
                }
            }
        }

        if (distance > ans) ans = distance;
    }
}
