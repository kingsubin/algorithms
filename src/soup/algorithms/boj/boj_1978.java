package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

// # 소수 찾기
public class boj_1978 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (isPN(n)) ans++;
        }
        
        System.out.println(ans);
    }

    static boolean isPN (int n) {
        if (n < 2) return false;
        for (int i = 2; i*i <= n;i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}
