package programmers.dfsbfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class OilDrilling {
    class Solution {

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        public int solution(int[][] land) {
            int answer = 0;
            int x = land.length;
            int y = land[0].length;

            int[][] ids = new int[x][y];
            Map<Integer, Integer> oils = new HashMap<>();

            int id = 1;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (land[i][j] == 1 && ids[i][j] == 0) {
                        int oil = 1;
                        ids[i][j] = id;
                        Queue<Place> q = new LinkedList<>();
                        q.add(new Place(i, j));

                        while (!q.isEmpty()) {
                            Place now = q.remove();

                            for (int k = 0; k < 4; k++) {
                                int xx = now.x + dx[k];
                                int yy = now.y + dy[k];

                                if (xx < 0 || yy < 0 || xx >= x || yy >= y) {
                                    continue;
                                }

                                if (ids[xx][yy] != 0) {
                                    continue;
                                }

                                if (land[xx][yy] == 1) {
                                    ids[xx][yy] = id;
                                    oil++;
                                    q.add(new Place(xx, yy));
                                }
                            }
                        }

                        oils.put(id++, oil);
                    }
                }
            }

            for (int i = 0; i < y; i++) {
                Set<Integer> flag = new HashSet<>();
                int value = 0;
                for (int j = 0; j < x; j++) {
                    if (flag.contains(ids[j][i]) || ids[j][i] == 0) {
                        continue;
                    }
                    flag.add(ids[j][i]);
                    value += oils.getOrDefault(ids[j][i], 0);
                }
                answer = Math.max(value, answer);
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
