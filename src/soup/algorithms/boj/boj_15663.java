package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static boolean[] v = new boolean[10];
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

        func(0, "");

        for (String s : set) {
            bw.append(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void func(int k, String str) throws IOException {
        if (k == m) {
            set.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (v[i]) continue;

            v[i] = true;
            func(k+1, str + val[i] + " ");
            v[i] = false;
        }
    }


}
