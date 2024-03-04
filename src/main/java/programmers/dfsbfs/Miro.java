package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Miro {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int answer = 0;
        int size = maps.length;
        int sizeX = maps[0].length();
        int[][] mapToL = new int[size][sizeX];
        int[][] mapToE = new int[size][sizeX];
        Queue<Position> qL = new LinkedList<>();
        Queue<Position> qE = new LinkedList<>();

        Position exit = new Position(0, 0);
        Position lever = new Position(0, 0);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < sizeX; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    qL.add(new Position(i, j));
                    mapToL[i][j] = 1;
                } else if (c == 'E') {
                    exit = new Position(i, j);
                } else if (c == 'L') {
                    lever = new Position(i, j);
                    mapToE[i][j] = 1;
                    qE.add(lever);
                } else if (c == 'X') {
                    mapToL[i][j] = -1;
                    mapToE[i][j] = -1;
                }
            }

        }
        int countToL = count(mapToL, qL, lever, size, sizeX);
        if (countToL == -1) {
            return -1;
        }
        answer += countToL;

        int countToE = count(mapToE, qE, exit, size, sizeX);

        if (countToE == -1) {
            return -1;
        }

        answer += countToE;
        return answer - 2;  // 초기값들 뺴기
    }

    public int count(int[][] map, Queue<Position> q, Position exit, int size, int sizeX) {
        while (!q.isEmpty()) {
            Position p = q.remove();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= sizeX) {
                    continue;
                }

                if (map[nextX][nextY] != 0) {
                    continue;
                }

                Position next = new Position(nextX, nextY);
                if (next.equals(exit)) {
                    return map[p.x][p.y] + 1;
                }

                q.add(next);
                map[next.x][next.y] = map[p.x][p.y] + 1;
            }
        }

        return -1;
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Position other) {
            return this.x == other.x && this.y == other.y;
        }
    }
}
