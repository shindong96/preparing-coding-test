package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingRobot {

    class Solution {

        int[] dR = {0, 1, 0, -1};
        int[] dC = {1, 0, -1, 0};

        public int solution(String[] board) {
            int answer = -1;
            int rowSize = board.length;
            int colSize = board[0].length();
            Queue<Position> q = new LinkedList<>();
            char[][] b = new char[rowSize][colSize];
            int[][] value = new int[rowSize][colSize];
            for (int i = 0; i < rowSize; i++) {
                b[i] = board[i].toCharArray();
                for (int j = 0; j < colSize; j++) {
                    if (b[i][j] == 'R') {
                        q.add(new Position(i, j));
                    }

                    if (b[i][j] == 'D') {
                        value[i][j] = -1;
                    }
                }
            }

            while (!q.isEmpty()) {
                Position p = q.remove();

                for (int i = 0; i < 4; i++) {
                    int nextRow = p.row;
                    int nextCol = p.col;
                    while (!(nextRow + dR[i] < 0 || nextCol + dC[i] < 0
                            || nextRow + dR[i] >= rowSize || nextCol + dC[i] >= colSize)
                            && value[nextRow + dR[i]][nextCol + dC[i]] != -1) {
                        nextRow += dR[i];
                        nextCol += dC[i];
                    }

                    if (nextRow == p.row && nextCol == p.col) {
                        continue;
                    }

                    if (value[nextRow][nextCol] != 0) {
                        continue;
                    }

                    value[nextRow][nextCol] = value[p.row][p.col] + 1;

                    if (b[nextRow][nextCol] == 'G') {
                        return value[nextRow][nextCol];
                    } else {
                        q.add(new Position(nextRow, nextCol));
                    }
                }
            }

            return answer;
        }

        class Position {
            int row;
            int col;

            public Position(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }
}
