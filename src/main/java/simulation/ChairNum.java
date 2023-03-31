package simulation;

// 4번 문제 

public class ChairNum {

    private static final int[] D_X = {0, 1, 0, -1};
    private static final int[] D_Y = {1, 0, -1, 0};

    // 1차 시도 오답...
    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];

        int a = 1;

        while (c * r - (c - 2) * (r - 2) <= k && c > 0 && r > 0) {
            k -= (c * r - (c - 2) * (r - 2));
            c -= 2;
            r -= 2;
            System.out.println(k);
            a++;
        }

        if (c <= 0 || r <= 0) {
            return new int[]{0, 0};
        }

        int directionIdx = 0;

        while (k - 1 != 0) {
            k--;
            //System.out.println(answer[0] + " " + answer[1]);

            int nextX = answer[1] + D_X[directionIdx];
            int nextY = answer[0] + D_Y[directionIdx];

            if (nextY < 0 || nextX < 0 || nextX >= c || nextY >= r) {
                directionIdx = (directionIdx + 1) % 4;
                nextX = answer[1] + D_X[directionIdx];
                nextY = answer[0] + D_Y[directionIdx];
            }
            answer[1] = nextX;
            answer[0] = nextY;

        }

        //System.out.println(r);
        answer[0] = r - 1 - answer[0] + a;
        answer[1] += a;
        //System.out.println(answer[0] + " " + answer[1]);

        return new int[]{answer[1], answer[0]};
    }

}
