package soup.algorithms.boj;

import java.io.*;

public class boj_1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String[] split = str.split("-");
        int ans = 0;

        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("\\+");

            sum += Integer.parseInt(split1[i]);
            ans -= sum;
        }

        System.out.println(ans);
    }
}
