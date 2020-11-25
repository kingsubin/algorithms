package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int row, col, min;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map = new int[10][10];
    static int[][] map2 = new int[10][10];
    static List<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) min++;
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctv.add(new int[] {i, j});
                }
            }
        }
    }

    static void solve() {
        for (int temp = 0; temp < (1 << (2 * cctv.size())); temp++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map2[i][j] = map[i][j];
                }
            }

            int brute = temp;
            for (int[] now : cctv) {
                int dir = brute % 4;
                brute /= 4;
                int x = now[0];
                int y = now[1];

                switch (map[x][y]) {
                    case 1:
                        upd(x, y, dir);
                        break;
                    case 2:
                        upd(x, y, dir);
                        upd(x, y, dir+2);
                        break;
                    case 3:
                        upd(x, y, dir);
                        upd(x, y, dir+1);
                        break;
                    case 4:
                        upd(x, y, dir);
                        upd(x, y, dir+1);
                        upd(x, y, dir+2);
                        break;
                    default:
                        upd(x, y, dir);
                        upd(x, y, dir+1);
                        upd(x, y, dir+2);
                        upd(x, y, dir+3);
                }
            }

            int val = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map2[i][j] == 0) val++;
                }
            }

            min = Math.min(min, val);
        }
        System.out.println(min);
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || map2[x][y] == 6) return;
            if (map2[x][y] != 0) continue;
            map2[x][y] = 7;
        }
    }

}
