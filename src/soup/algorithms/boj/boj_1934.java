package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

// # 최소 공배수
public class boj_1934 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lcm = a*b / gcd(a, b);
            bw.write(lcm+"\n");
        }

        bw.flush();
        bw.close();
    }

    static int gcd (int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
}
