package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans;
    static String str;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (solve(str)) ans++;
        }

        System.out.println(ans);
    }

    static boolean solve(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i-1);
            char c1 = s.charAt(i);
            if (c == c1) continue;

            if (sb.indexOf(String.valueOf(c1)) != -1) {
                return false;
            } else {
                sb.append(c1);
            }
        }

        return true;
    }
}
