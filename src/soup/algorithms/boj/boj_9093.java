package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            str += '\n';
            Stack<Character> stack = new Stack<Character>();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ' ' || str.charAt(j) == '\n') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(str.charAt(j));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
