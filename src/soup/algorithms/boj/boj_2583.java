package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2583 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();
    static int row, col, k, nx, ny;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        v = new boolean[row][col];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int x = row - startY;
            int x2 = row - endY;

            for (int j = Math.min(x, x2); j <= Math.max(x, x2); j++) {
                for (int l = Math.min(startX, endX); l <= Math.max(startX, endX); l++) {
                    map[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

//        int cnt = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (map[i][j] == 0 && !v[i][j]) {
//                    v[i][j] = true;
//                    q.offer(new int[] {i, j});
//                    cnt++;
//
//                    while (!q.isEmpty()) {
//                        int[] now = q.poll();
//
//                        for (int l = 0; l < 4; l++) {
//                            nx = now[0] + dx[l];
//                            ny = now[1] + dy[l];
//
//                            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
//                                continue;
//                            }
//
//                            if (!v[nx][ny] && map[nx][ny] == 0) {
//                                q.offer(new int[] {nx, ny});
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(cnt);
    }
}
