package thisiscote.implementation;

public class Knight {


    private static final int[] DIR = {1, -1};
    private static final int SIZE = 8;

    public int solution(char col, int row) {
        int answer = 0;
        int x = (int) (col - 'a');
        int y = row;

        answer += count(x, y);
        answer += count(y, x);

        return answer;
    }

    private int count(int a, int b) {
        int answer = 0;

        for (int i = 0; i < DIR.length; i++) {
            if (a + 2 * DIR[i] > SIZE || a + 2 * DIR[i] < 1) {
                continue;
            }

            for (int j = 0; j < DIR.length; j++) {
                if (b + DIR[j] > SIZE || b + DIR[j] < 1) {
                    continue;
                }
                answer++;
            }
        }
        return answer;
    }
}
