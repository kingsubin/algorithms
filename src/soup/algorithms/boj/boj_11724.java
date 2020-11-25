package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] v;
    static ArrayList<Integer>[] list;
    static int N, M, x, y, ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        v = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!v[i]) {
                bfs(i);
                ans++;
            }
        }
    }

    static void bfs(int node) {
        q.offer(node);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);

                if (!v[next]) {
                    v[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
