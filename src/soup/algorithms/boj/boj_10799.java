package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10799 {
    static Stack<Integer> s = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                s.push(i);
            } else {
                if (i > 0 && s.peek() == (i-1)) { // 레이저
                    s.pop();
                    ans += s.size();
                } else { // 막대의 끝
                    s.pop();
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
