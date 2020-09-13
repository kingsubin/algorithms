package soup.algorithms.boj;

import java.io.*;

public class boj_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int temp = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    temp++;
                } else if (str.charAt(j) == ')') {
                    temp--;
                }

                if (temp < 0) {
                    bw.append("NO" +"\n");
                    break;
                }
            }

            if (temp == 0) {
                bw.append("YES" + "\n");
            } else if (temp > 0){
                bw.append("NO" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
