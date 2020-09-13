package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;

public class boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String first = br.readLine();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < first.length(); i++) {
            left.push(first.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L' :
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D' :
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B' :
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P' :
                    left.push(command.charAt(2));
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            bw.append(right.pop());
        }

        bw.flush();
        bw.close();
    }
}
