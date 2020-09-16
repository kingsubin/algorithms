package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

// # 숨바꼭질 6
public class boj_17087 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = gcd(ans, Math.abs(Integer.parseInt(st.nextToken()) - s));
        }

        System.out.println(ans);
    }

    static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
