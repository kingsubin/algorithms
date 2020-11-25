package soup.algorithms.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class boj_2504 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = sc.nextLine();

        Stack<String> stack = new Stack<>();
        int roundBracket = 0;
        int squareBracket = 0;

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);

            switch (s) {
                case "(":
                    roundBracket++;
                    stack.push(s);
                    break;
                case "[":
                    squareBracket++;
                    stack.push(s);
                    break;
                case ")":
                    roundBracket--;
                    if (roundBracket > -1) {

                        if (stack.peek().equals("(")) {
                            stack.pop();
                            stack.push("2");
                        } else {
                            int roundResult = 0;

                            while (!stack.isEmpty()) {
                                if (stack.peek().equals("[")) { // 잘못된 문자열 처리
                                    bw.write("0");
                                    bw.flush();
                                    return;
                                } else if (stack.peek().equals("(")) {
                                    stack.pop();
                                    roundResult *= 2;
                                    stack.push(String.valueOf(roundResult));
                                    break;
                                } else {
                                    roundResult += Integer.parseInt(stack.pop()); // 스택안에 괄호 사이의 숫자값 처리
                                }
                            }
                        }
                    }
                    break;
                case "]":
                   squareBracket--;

                   if (squareBracket > -1) {
                       if (stack.peek().equals("[")) {
                           stack.pop();
                           stack.push("3");
                       } else {
                           int squareResult = 0;

                           while (!stack.isEmpty()) {
                                if (stack.peek().equals("(")) {
                                    bw.write("0");
                                    bw.flush();
                                    return;
                                } else if (stack.peek().equals("[")) {
                                    stack.pop();
                                    squareResult *= 3;
                                    stack.push(String.valueOf(squareResult));
                                    break;
                                } else {
                                    squareResult += Integer.parseInt(stack.pop());
                                }
                           }
                       }
                   }
                   break;
            }

            if (squareBracket < 0 || roundBracket < 0) {
                bw.write("0");
                bw.flush();
                return;
            }
        }

        if (squareBracket != 0 || roundBracket != 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        int ans = 0 ;
        while (!stack.isEmpty()) {
            ans += Integer.parseInt(stack.pop());
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}