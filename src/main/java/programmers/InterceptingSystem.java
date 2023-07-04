package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptingSystem {

    public int solution(int[][] targets) {
        int end = 0;
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];

            if (s < end) {
                continue;
            } else {
                end = e;
                answer++;
            }
        }

        return answer;
    }
}
