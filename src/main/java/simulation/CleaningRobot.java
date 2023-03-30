package simulation;

// 2번 청소

public class CleaningRobot {

    private static final int[] D_X = {1, 0, -1, 0};
    private static final int[] D_Y = {0, 1, 0, -1};

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];

        int size = board.length;

        int directionIdx = 0;

        for (int i = 0; i < k; i++) {
            final int nextY = answer[0] + D_Y[directionIdx];
            final int nextX = answer[1] + D_X[directionIdx];

            if (nextY == size || nextX == size ||
                    nextX < 0 || nextY < 0 ||
                    board[nextY][nextX] == 1) {
                directionIdx++;
                directionIdx %= 4;
                continue;
            }

            answer[0] = nextY;
            answer[1] = nextX;
        }
        return answer;
    }
}
