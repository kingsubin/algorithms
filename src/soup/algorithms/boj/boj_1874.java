package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine()); // 1 ~ 100,000

        int item = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x > item) {
                while (item < x) {
                    s.push(++item);
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            } else {
                boolean found = false;
                if (!s.isEmpty()) {
                    int top = s.peek();
                    s.pop();
                    sb.append("-\n");

                    if (x == top) {
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
