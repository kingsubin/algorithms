package soup.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] vowelCheck = {'a', 'e', 'i', 'o', 'u'};
    static char[] chars;
    static int L, C;
    static final int minVowel = 1;
    static final int minConsonant = 2;
    static List<String> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();
        solve();
//        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            char c = st.nextToken().charAt(0);
            chars[i] = c;
        }
    }

    static void solve() {
        Arrays.sort(chars);

        a : for (int i = 0; i < chars.length + 1 - L; i++) { // chars[i] 를 시작으로 하는 문자열
            StringBuilder sb = new StringBuilder();
            char start = chars[i];

            int vowelCount = 0;
            int consonantCount = 0;
            int length = 0;

            if (isVowel(start)) {
                vowelCount++;
            } else {
                consonantCount++;
            }

            sb.append(start);
            length++;

            for (int j = i + 1; j < chars.length; j++) {
                char now = chars[j];

                if (isVowel(now)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }

                sb.append(now);
                length++;

                // 조건 검사
                if (vowelCount >= minVowel && consonantCount >= minConsonant && sb.length() == L) {
                    list.add(sb.toString());
                    sb.deleteCharAt(sb.length()-1);
                }
                
            }
        }
    }

    static boolean isVowel(char c) {
        for (char value : vowelCheck) {
            if (c == value) return true;
        }
        return false;
    }
}
