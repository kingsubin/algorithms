package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10799_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack = new Stack<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);

            if (val == '(') {
                stack.push(val);
            } else if (val == ')') {
                if (stack.peek() == str.charAt(i-1)) { // 레이저
                    ans += (stack.size() - 1);
                } else { // 막대의 끝
                    ans++;
                }
                stack.pop();
            }
        }

        System.out.println(ans);
    }
}
