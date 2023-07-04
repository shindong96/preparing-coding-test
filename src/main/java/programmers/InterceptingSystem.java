package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptingSystem {

    public static void main(String[] args) {
        final InterceptingSystem interceptingSystem = new InterceptingSystem();
        int[][] ints = new int[3][];
        ints[0] = new int[]{1, 4};
        ints[1] = new int[]{1, 5};
        ints[2] = new int[]{1, 3};
        interceptingSystem.solution(ints);
        System.out.println();
    }

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
