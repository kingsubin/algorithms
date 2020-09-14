package soup.algorithms.boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < m-1; i++) {
                q.offer(q.poll());
            }

            if (q.size() == 1) {
                sb.append(String.valueOf(q.poll()));
            } else {
                sb.append(String.valueOf(q.poll())).append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}
