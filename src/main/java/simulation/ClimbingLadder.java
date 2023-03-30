package simulation;

// 1번 사다리 타기

public class ClimbingLadder {

    public char[] solution(int n, int[][] ladder) {
        char[] answer = init(n);

        for (int[] l : ladder) {
            for (int i : l) {
                swapAlphabet(answer, i);
            }
        }
        return answer;
    }

    private void swapAlphabet(char[] answer, int i) {
        char tmp = answer[i - 1];
        answer[i - 1] = answer[i];
        answer[i] = tmp;
    }

    private char[] init(final int n) {
        char[] answer = new char[n];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (char) ('A' + i);
        }

        return answer;
    }

}
