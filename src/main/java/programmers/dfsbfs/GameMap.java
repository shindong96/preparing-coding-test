package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {

    class Solution {

        private int dx[] = {1, 0, -1, 0};
        private int dy[] = {0, 1, 0, -1};

        public int solution(int[][] maps) {
            int answer = -1;
            int targetX = maps.length - 1;
            int targetY = maps[0].length - 1;
            Queue<Place> q = new LinkedList<>();
            q.add(new Place(0, 0));

            while (!q.isEmpty()) {
                Place place = q.remove();

                for (int i = 0; i < 4; i++) {
                    int x = place.x + dx[i];
                    int y = place.y + dy[i];
                    if (x < 0 || y < 0 || x > targetX || y > targetY) {
                        continue;
                    }

                    if (maps[x][y] != 1) {
                        continue;
                    }

                    Place next = new Place(x, y);
                    maps[x][y] = maps[place.x][place.y] + 1;
                    q.add(next);

                    if (x == targetX && y == targetY) {
                        return maps[x][y];
                    }
                }
            }

            return answer;
        }

        class Place {
            int x;
            int y;

            public Place(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
