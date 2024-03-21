package programmers.twopoint;

public class JoyStick {

    // "AAAAABBAAAAAAABAAA"처럼 맨앞 맨뒤가 'A'로 붙은 케이스 해결 못함..

    public int solution(String name) {
        int answer = 0;
        char[] alphas = name.toCharArray();
        int s = 0;
        int e = 0;
        int c = 0;
        int ss = 0;
        int max = 0;
        for (int i = 0; i < alphas.length; i++) {
            char alpha = alphas[i];
            if (alpha == 'A') {
                c++;

                if (ss == 0) {
                    ss = i;
                }

                if (i == alphas.length - 1) {
                    if (c > max) {
                        s = ss;
                        e = i;
                        max = c;
                    }
                }
                continue;
            }

            if (ss != 0) {
                if (c > max) {
                    s = ss;
                    e = i - 1;
                    max = c;
                }
                ss = 0;
                c = 0;
            }

            int count = alpha - 'A';
            count = (count <= 13) ? count : 26 - count;
            answer += count;
        }

        if (max == 0) {
            return answer + alphas.length - 1;
        }

        int r = (s == 0) ? s : s - 1;
        int l = alphas.length - e - 1;

        int min = Math.min(r, l);

        answer += r + l;
        answer += Math.min(max, min);

        return answer;
    }
}
