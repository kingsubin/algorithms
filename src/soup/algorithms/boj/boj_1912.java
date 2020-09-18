package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] a;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        /** 깔끔한 점화식 풀이
         * for (int i = 1; i <= n; i++) {
         *             dp[i] = a[i];
         *             if (i == 0) continue;
         *             if (dp[i] < dp[i-1] + a[i]) {
         *                 dp[i] = dp[i-1] + a[i];
         *             }
         *         }
         */

        a = new int[n+1];
        dp = new int[n+1];

        int max = -1001;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] > max) {
                max = a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i-1] + a[i] > 0) {
                dp[i] = dp[i-1] + a[i];
            }
        }

        int ans = -1001;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }

        // 음수일때
        if (ans == 0) ans = max;

        System.out.println(ans);
    }
}