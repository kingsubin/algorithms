package soup.algorithms.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Razer> waiting = new Stack<>();
    static Stack<Razer> pending = new Stack<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        // 스택에 반대로 쌓기
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n; i > 0; i--) {
            waiting.push(new Razer(arr[i], i));
        }

        // 초기값
        pending.push(waiting.pop());
        list.add(0);

        while (!waiting.isEmpty()) {

            if (waiting.peek().height > pending.peek().height) { // 레이저가 닿지 못하는 경우
                while (!pending.isEmpty() && (pending.peek().height < waiting.peek().height)) { // 닿는 곳 까지
                    pending.pop(); // 작은놈은 필요없음
                }

                if (pending.isEmpty()) { // 끝까지 못 찾음
                    list.add(0);
                } else { // 어딘가에 닿았음
                    list.add(pending.peek().index);
                }
            } else { // 레이저가 바로 닿음
                list.add(pending.peek().index);
            }

            pending.push(waiting.pop());
        }

        // 출력
        for (Integer i : list) {
            bw.append(i + " ");
        }
        bw.flush();
        bw.close();
    }
}

class Razer {
    int height;
    int index;

    public Razer(int height, int index) {
        this.height = height;
        this.index = index;
    }
}