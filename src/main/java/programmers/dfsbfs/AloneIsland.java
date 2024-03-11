package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AloneIsland {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int[][] board = new int[maps.length][maps[0].length()];
        boolean[][] flag = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            char[] map = maps[i].toCharArray();
            for (int j = 0; j < map.length; j++) {
                if (map[j] != 'X') {
                    board[i][j] = map[j] - '0';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (flag[i][j] || board[i][j] == 0) {
                    continue;
                }

                int value = 0;
                flag[i][j] = true;
                Queue<Position> q = new LinkedList<>();
                q.add(new Position(i, j));

                while (!q.isEmpty()) {
                    Position p = q.remove();
                    value += board[p.x][p.y];
                    for (int d = 0; d < 4; d++) {
                        int nextX = p.x + dx[d];
                        int nextY = p.y + dy[d];

                        if (nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[i].length) {
                            continue;
                        }

                        if (flag[nextX][nextY] || board[nextX][nextY] == 0) {
                            continue;
                        }

                        flag[nextX][nextY] = true;
                        q.add(new Position(nextX, nextY));
                    }
                }
                answer.add(value);
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
