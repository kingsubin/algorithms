package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;

public class boj_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int cnt = 0;

        while ( !(str = br.readLine()).contains("-") ) {
            cnt++;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            char[] arr = new char[stack.size()];
            for (int i = arr.length-1; i >= 0; i--) {
                arr[i] = stack.pop();
            }

            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) { // 짝수
                    if (arr[i] == '}') ans++;
                } else { // 홀수
                    if (arr[i] == '{') ans++;
                }
            }

            bw.write(cnt + ". " + ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}
