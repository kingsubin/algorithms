package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_16929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<int[]> s;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int row, col, val, nx, ny, k, startX, startY;
    static boolean isCycle;

    public static void main(String[] args) throws IOException {
        input();
        solve();

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }


    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
    }

    static void solve() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                val = map[i][j]; // 현재 color
                startX = i; // start point
                startY = j;

                dfs(i, j);
            }
        }

        System.out.println("No");
    }

    static void dfs(int x, int y) {
        s = new Stack<>();
        v = new boolean[row][col];

        v[x][y] = true;
        s.push(new int[] {x, y, 1});

        while (!s.isEmpty()) {
            int[] now = s.pop();

            for (int i = 0; i < 4; i++) {
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                k = now[2] + 1;

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (k >= 4 && map[nx][ny] == val) {
                    if (nx == startX && ny == startY + 1) {
                        isCycle = true;
                        return;
                    } else if (nx == startX && ny == startY - 1) {
                        isCycle = true;
                        return;
                    } else if (nx == startX + 1 && ny == startY) {
                        isCycle = true;
                        return;
                    } else if (nx == startX - 1 && ny == startY) {
                        isCycle = true;
                        return;
                    }
                }

                if (map[nx][ny] == val && !v[nx][ny]) {
                    v[nx][ny] = true;
                    s.push(new int[] {nx, ny, k});

                    System.out.println("k : " + k + ", nx : " + nx + ", ny : " + ny);
                    System.out.println("map[nx][ny] : " + map[nx][ny] + ", val : " + val);
                }
            }
        }
    }
}
