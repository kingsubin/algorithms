package soup.algorithms.boj;

import java.io.*;
import java.util.Stack;

public class boj_9012_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int cnt = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    cnt++;
                } else {
                    cnt--;
                }

                if (cnt < 0) {
                    bw.append("NO" + "\n");
                    break;
                }
            }

            if (cnt == 0) {
                bw.append("YES\n");
            } else if (cnt > 0) {
                bw.append("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
