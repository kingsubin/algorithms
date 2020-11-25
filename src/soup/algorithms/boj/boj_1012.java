package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] v = new boolean[50][50];
    static int[][] map = new int[50][50];
    static int[] dx = {-1, 0}; // 하, 우임 만 움직
    static int[] dy = {0, 1};
    static Queue<int[]> q = new LinkedList<>();
    static int t, row, col, k, nx, ny;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int j = 0; j < row; j++) {
                for (int l = 0; l < col; l++) {
                    if (!v[j][l] && map[j][l] == 1) {
                        v[j][l] = true;
                        q.offer(new int[] {j, l});

                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            for (int m = 0; m < 2; m++) {
                                nx = now[0] + dx[m];
                                ny = now[1] + dy[m];

                                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                                if (!v[nx][ny] && map[nx][ny] == 1) {
                                    v[nx][ny] = true;
                                    q.offer(new int[] {nx, ny});
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
