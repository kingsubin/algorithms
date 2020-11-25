package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[] v;
    static int[] a;
    static int F, S, G, U, D, ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        if (ans == -1) System.out.println("use the stairs");
        else System.out.println(ans);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        v = new boolean[F + 1];
        a = new int[F + 1];
        ans = -1;
    }

    static void solve() {
        q.offer(new int[]{S, 0});
        v[S] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int floor = now[0];
            int cnt = now[1];

            if (floor == G) { // 목표층 도달
                ans = cnt;
                break;
            }

            int up = floor + U;
            int down = floor - D;

            if (up <= F && !v[up]) {
                v[up] = true;
                q.offer(new int[]{up, cnt + 1});
            }

            if (down >= 1 && !v[down]) {
                v[down] = true;
                q.offer(new int[]{down, cnt + 1});
            }
        }
    }
}
