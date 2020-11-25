package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int ans = func(N, r, c);
        System.out.println(ans);
    }

    static int func(int n, int r, int c) {
        if (n == 0) return 0;
        int half = (int) Math.pow(2, n-1);

        // 1번 사각형
        if (r < half && c < half) {
            return func(n-1, r, c);
        }
        // 2번 사각형
        if (r < half && c >= half) {
            return half*half + func(n-1, r, c-half);
        }
        // 3번 사각형
        if (r >= half && c < half) {
            return 2*half*half + func(n-1, r-half, c);
        }
        // 4번 사각형
        return 3*half*half + func(n-1, r-half, c-half);
    }
}
