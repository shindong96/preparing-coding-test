package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TurningQueue {

    public static void main(String[] args) {
        final TurningQueue turningQueue = new TurningQueue();
        turningQueue.solution();
    }

    public void solution() {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.add(scanner.nextInt() - 1);
        }

        int num = 0;
        int sumMovingIdx = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int removeInt = queue.remove();
            removeInt += sumMovingIdx;

            if (removeInt < 0) {
                removeInt += n;
            }

            final int movingCount = moveCount(removeInt, n);
            sumMovingIdx += movingCount;
            answer += Math.abs(movingCount);
            n--;
            num++;
            System.out.println(sumMovingIdx + " " + answer);
        }

        System.out.println(answer);
    }

    public int moveCount(int idx, int idxSize) {
        int secondCase = -idx;
        int thirdCase = idxSize - idx;

        if (secondCase + thirdCase >= 0) {
            return secondCase;
        }

        return thirdCase;
    }

}
