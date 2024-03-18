package programmers.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LightCycle {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        Point[][] points = new Point[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            char[] ps = grid[i].toCharArray();

            for (int j = 0; j < ps.length; j++) {
                int direction;

                if (ps[j] == 'S') {
                    direction = 0;
                } else if (ps[j] == 'L') {
                    direction = -1;
                } else {
                    direction = 1;
                }
                points[i][j] = new Point(i, j, direction);
            }
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                Point point = points[i][j];

                for (int p = 0; p < 4; p++) {
                    if (point.flag[p]) {
                        continue;
                    }

                    Point now = point;
                    int dir = now.getNextDir(p);
                    Point next = points[now.getNextX(dir, points.length)][now.getNextY(dir, points[i].length)];

                    int count = 1;
                    while (!(next.flag[dir])) {
                        now = next;
                        dir = now.getNextDir(dir);
                        next = points[now.getNextX(dir, points.length)][now.getNextY(dir, points[i].length)];
                        count++;
                    }

                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    class Point {
        int x;
        int y;
        int direction;
        boolean[] flag;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            flag = new boolean[]{false, false, false, false};
        }

        int getNextX(int dir, int size) {
            return (x + dx[dir] + size) % size;
        }

        int getNextY(int dir, int size) {
            return (y + dy[dir] + size) % size;
        }

        int getNextDir(int dir) {
            flag[dir] = true;
            return (dir + direction + 4) % 4;
        }
    }
}
