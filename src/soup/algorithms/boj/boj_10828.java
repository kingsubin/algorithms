package soup.algorithms.boj;

import java.io.*;

public class boj_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stack s = new stack(N);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            switch (str) {
                case "push" : s.push(Integer.parseInt(str.split(" ")[1]));
                case "pop" : s.pop();
                case "size" : s.size();
                case "top" : s.top();
                case "empty" :
                    int empty = s.empty();
                    if (empty == 1) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
            }
        }
    }
}

class stack {
    int top;
    int size;
    int[] arr;

    public stack(int size) {
        top = -1;
        this.size = size;
        arr = new int[this.size];
    }

    public int empty() {
        return top == -1 ? 1 : 0;
    }

    public void push(int item) {
        arr[++top] = item;
    }

    public void pop() {
        if (empty() == 1) {
            System.out.println(-1);
        } else {
            System.out.println(arr[top]);
            arr[top--] = 0;
        }
    }

    public void top() {
        if (empty() == 1) {
            System.out.println(-1);
        } else {
            System.out.println(arr[top]);
        }
    }

    public void size() {
        System.out.println(top+1);
    }
}