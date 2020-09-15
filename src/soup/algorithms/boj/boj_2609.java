package soup.algorithms.boj;

import java.io.*;
import java.util.StringTokenizer;

// # 최대 공약수와 최소 공배수
public class boj_2609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a, b));
        System.out.println(a*b / gcd(a,b));
    }

    static int gcd (int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }

}
