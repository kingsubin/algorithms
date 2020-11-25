package soup.algorithms.boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15666 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] a = new int[10];
    static int[] val;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        val = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(val);

        func(0);
        bw.flush();
        bw.close();
    }

    static void func(int k) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                bw.append(a[i] + " ");
            }
            bw.newLine();
            return;
        }

        int before = 0;
        for (int i = 0; i < n; i++) {
            if (before == val[i]) continue;
            if (k != 0 && a[k-1] > val[i]) continue;

            a[k] = val[i];
            before = a[k];

            func(k + 1);
        }
    }
}
