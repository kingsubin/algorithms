package soup.algorithms.boj;

import java.io.*;

public class boj_10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[(N*2) + 2];
        int head = N;
        int tail = N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            String command = s[0];

            switch (command) {
                case "push_front":
                    arr[head--] = Integer.parseInt(s[1]);
                    break;
                case "push_back":
                    arr[++tail] = Integer.parseInt(s[1]);
                    break;
                case "pop_front":
                    if (tail - head == 0) {
                        bw.write("-1\n");
                    } else {
                        int val = arr[++head];
                        bw.write(val + "\n");
                    }
                    break;
                case "pop_back":
                    if (tail - head == 0) {
                        bw.write("-1\n");
                    } else {
                        int val = arr[tail--];
                        bw.write(val + "\n");
                    }
                    break;
                case "size":
                    bw.write(tail - head + "\n");
                    break;
                case "empty":
                    if (tail - head == 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (tail - head == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(arr[head + 1] + "\n");
                    }
                    break;
                case "back":
                    if (tail - head == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(arr[tail] + "\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
