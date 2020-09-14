package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;

public class boj_17413 {
    static Stack<Character> s = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] chars = br.readLine().toCharArray();
        boolean isTag = false;

        for (char aChar : chars) {
            if (aChar == '<') {
                while (!s.isEmpty()) {
                    sb.append(s.pop());
                }
                sb.append(aChar);
                isTag = true;
            } else if (aChar == '>') {
                sb.append(aChar);
                isTag = false;
            } else if (isTag) {
                sb.append(aChar);
            } else {
                if (aChar == ' ') {
                    while (!s.isEmpty()) {
                        sb.append(s.pop());
                    }
                    sb.append(' ');
                } else {
                    s.push(aChar);
                }
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb.toString());
    }
}
