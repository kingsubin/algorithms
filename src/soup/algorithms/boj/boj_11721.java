package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11721 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int length = str.length();

        while (length >= 10) {
            String substring = str.substring(0, 10);
            System.out.println(substring);
            str = str.substring(10);
            length -= 10;
        }

        System.out.println(str);
    }
}
