package soup.algorithms.boj;

import java.io.*;
import java.util.*;

public class boj_6198 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        long ans = 0;
        int N = Integer.parseInt(br.readLine());

        // 현재 나를 몇개의 빌딩이 볼 수 있는가 ? 를 기준으로 생각
        for (int i = 0; i < N; i++) { // 모든 빌딩들에 대하여 검사
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= height) { // 스택안의 빌딩들은 나를 볼 수 없다
                    stack.pop(); // 제거
                } else { // 스택 안의 빌딩들 -> 나를 볼 수 있는 빌딩들 -> 나보다 높이가 큰 빌딩들
                    ans += stack.size();
                    break;
                }
            }
            stack.push(height);
        }
        System.out.println(ans);
    }
}

