package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();
    static int row, col, h, nx, ny, nz;
    static int[][][] map;
    static boolean[][][] v;
    static int[] dx = {0, 0, -1, 1, 0, 0}; // 위 아래 상 하 좌 우
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[row][col][h];
        v = new boolean[row][col][h];
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());

                    if (map[j][k][i] == 0) cnt++;

                    if (map[j][k][i] == 1) {
                        v[j][k][i] = true;
                        q.offer(new int[]{j, k, i, 0});
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            int day = now[3];
            ans = day;

            for (int i = 0; i < 6; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                nz = z + dz[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= col || nz < 0 || nz >= h) {
                    continue;
                }

                if (!v[nx][ny][nz] && map[nx][ny][nz] == 0) {
                    v[nx][ny][nz] = true;
                    map[nx][ny][nz] = 1;
                    q.offer(new int[] {nx, ny, nz, day + 1});
                }
            }
        }

        System.out.println(ans);
    }
}
