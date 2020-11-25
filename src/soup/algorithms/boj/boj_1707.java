package soup.algorithms.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> q;
    static int[] check;
    static ArrayList<Integer>[] list;
    static int K, V, E, x, y, vertex;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            input();
            solve();
        }

        bw.flush();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        check = new int[V+1];
        isBipartite = true;

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }
    }

    static void solve() throws IOException {
        for (int i = 1; i <= V; i++) {
            if (!isBipartite) { // false임이 먼저 밝혀진다면
                break;
            }

            if (check[i] == 0) { // 방문하지 않았다면 탐색 시작
                bfs(i, 1);
            }
        }

        if (isBipartite) bw.write("YES\n");
        else bw.write("NO\n");
    }

    static void bfs(int start, int btn) {
        q = new LinkedList<>();

        q.offer(start);
        check[start] = btn; // 초기값 1

        while (!q.isEmpty() && isBipartite) {
            vertex = q.poll();

            for (int next : list[vertex]) {
                if (check[next] == 0) { // 방문하지 않은 정점이라면
                    check[next] = check[vertex] * -1; // -1을 곱해 번갈아가며 체크
                    q.offer(next);
                } // 중간에 이분그래프가 아님이 밝혀진다면
                else if (check[vertex] + check[next] != 0) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
