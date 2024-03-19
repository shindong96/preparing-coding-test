package programmers.simulation;

import java.util.ArrayList;
import java.util.List;

public class BilliardPractice {

    static int MAX = 2 * (int) Math.pow(1000, 2);

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new ArrayList<>();
        Point start = new Point(startX, startY);

        for (int[] ball : balls) {
            Point point = new Point(ball[0], ball[1]);
            answer.add(start.calculate(m, n, point));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int calculate(int m, int n, Point p) {
            int min = MAX;
            int[] value = new int[4];

            value[0] = x == p.x && p.y < y ? MAX : (int) Math.pow(x - p.x, 2) + (int) Math.pow(y + p.y, 2);
            value[1] = x == p.x && p.y > y ? MAX : (int) Math.pow(x - p.x, 2) + (int) Math.pow((n - y) + (n - p.y), 2);
            value[2] = y == p.y && p.x < x ? MAX : (int) Math.pow(y - p.y, 2) + (int) Math.pow(x + p.x, 2);
            value[3] = y == p.y && p.x > x ? MAX : (int) Math.pow(y - p.y, 2) + (int) Math.pow((m - x) + (m - p.x), 2);

            for (int v : value) {
                min = min < v ? min : v;
            }
            return min;
        }
    }
}
