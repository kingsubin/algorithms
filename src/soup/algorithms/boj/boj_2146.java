package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] v;
    static int[][] a, map;
    static int ans = Integer.MAX_VALUE;
    static int N, islandCnt, nx, ny;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        createMap();
        findDistance();

        System.out.println(ans);
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        a = new int[N][N];
        map = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void createMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 1 && !v[i][j]) {
                    islandCnt++;

                    map[i][j] = islandCnt;
                    v[i][j] = true;
                    q.offer(new int[] {i, j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            nx = now[0] + dx[k];
                            ny = now[1] + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (!v[nx][ny] && a[nx][ny] == 1) {
                                map[nx][ny] = islandCnt;
                                v[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
    }

    static boolean isEdge(int i, int j) {
        for (int k = 0; k < 4; k++) {
            nx = i + dx[k];
            ny = j + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (map[nx][ny] == 0) return true;
        }

        return false;
    }

    static void findDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && isEdge(i, j)) {
                    v = new boolean[N][N];
                    q.offer(new int[] {i, j, 0});
                    int landNum = map[i][j];

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        int dist = now[2];

                        for (int k = 0; k < 4; k++) {
                            nx = now[0] + dx[k];
                            ny = now[1] + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                            if (map[nx][ny] != 0 && map[nx][ny] != landNum) {
                                ans = Math.min(ans, dist);
                            }

                            if (map[nx][ny] == 0 && !v[nx][ny]) {
                                v[nx][ny] = true;
                                q.offer(new int[] {nx, ny, dist + 1});
                            }

                        }
                    }
                }
            }
        }
    }

}
