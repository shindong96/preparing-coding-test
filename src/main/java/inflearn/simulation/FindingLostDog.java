package inflearn.simulation;

// 3번 문제

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindingLostDog {

    private static final int[] D_X = {0, 1, 0, -1};
    private static final int[] D_Y = {-1, 0, 1, 0};
    private static final int BOARD_SIZE = 10;
    private static final int TIME_LIMIT = 10_000;

    public int solution(int[][] board) {
        int answer = 0;

        List<Integer> hyunSu = new ArrayList<>(Arrays.asList(0, 0));
        List<Integer> dog = new ArrayList<>(Arrays.asList(0, 0));

        int hyunSuDirectionIdx = 0;
        int dogDirectionIdx = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 2) {
                    hyunSu.set(0, i);
                    hyunSu.set(1, j);
                }

                if (board[i][j] == 3) {
                    dog.set(0, i);
                    dog.set(1, j);
                }
            }
        }

        int i;
        for (i = 0; i < TIME_LIMIT; i++) {
            if (hyunSu.get(0).equals(dog.get(0)) &&
                    hyunSu.get(1).equals(dog.get(1))) {
                break;
            }

            int hyunSuNextY = hyunSu.get(0) + D_Y[hyunSuDirectionIdx];
            int hyunSuNextX = hyunSu.get(1) + D_X[hyunSuDirectionIdx];

            int dogNextY = dog.get(0) + D_Y[dogDirectionIdx];
            int dogNextX = dog.get(1) + D_X[dogDirectionIdx];

            if (hyunSuNextX == BOARD_SIZE || hyunSuNextY == BOARD_SIZE
                    || hyunSuNextY < 0 || hyunSuNextX < 0 || board[hyunSuNextY][hyunSuNextX] == 1) {
                hyunSuDirectionIdx++;
                hyunSuDirectionIdx %= 4;
            } else {
                hyunSu.set(0, hyunSuNextY);
                hyunSu.set(1, hyunSuNextX);
            }

            if (dogNextX == BOARD_SIZE || dogNextY == BOARD_SIZE
                    || dogNextX < 0 || dogNextY < 0 || board[dogNextY][dogNextX] == 1) {
                dogDirectionIdx++;
                dogDirectionIdx %= 4;
            } else {
                dog.set(0, dogNextY);
                dog.set(1, dogNextX);
            }

            answer++;
        }

        if (i == TIME_LIMIT) {
            return 0;
        }

        return answer;
    }
}
