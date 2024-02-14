package thisiscote.greedy;

public class NumCard {

    public int solution(int[][] numbers) {
        int m = numbers[0].length;
        int big = 0;

        for (int[] number : numbers) {
            int small = 10000;
            for (int i = 0; i < m; i++) {
                small = Math.min(small, number[i]);
            }

            big = Math.max(small, big);
        }

        return big;
    }

}
