package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;

public class boj_10773 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        long ans = 0;
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) {
                ans -= s.pop();
            } else {
                s.push(val);
                ans += val;
            }
        }

        System.out.println(ans);
    }
}