package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] val;
    static int n, s, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        val = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (s == 0) ans--;
        System.out.println(ans);
    }

    static void func(int k, int sum) {
        if (k == n) {
            if (sum == s) ans++;
            return;
        }

        func(k + 1, sum);
        func(k + 1, sum + val[k]);
    }
}
