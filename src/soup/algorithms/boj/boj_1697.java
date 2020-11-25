package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] v = new boolean[100001];
    static int[] dx = {-1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int n, int k) {
        if (n == k) return 0;

        v[n] = true;
        q.offer(new int[] {n, 0});

        int nx;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 3; i++) {
                if (i == 2) nx = now[0] * 2;
                else nx = now[0] + dx[i];

                if (nx < 0 || nx > 100000 || v[nx]) continue;
                if (nx == k) return now[1] + 1;

                q.offer(new int[] {nx, now[1] + 1});
                v[nx] = true;
            }

        }
        return 0;
    }
}
