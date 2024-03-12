package programmers.twopoint;

public class DeliveryPickUp {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = n - 1;
        int p = n - 1;

        while (p >= 0 || d >= 0) {
            while (p >= 0 && pickups[p] == 0) {
                p--;
            }

            while (d >= 0 && deliveries[d] == 0) {
                d--;
            }

            if (p >= 0 || d >= 0) {
                answer += ((d > p) ? 2L * (d + 1) : 2L * (p + 1));
            }

            int sumP = 0;
            while (p >= 0) {
                if (sumP + pickups[p] > cap) {
                    pickups[p] -= (cap - sumP);
                    break;
                }

                sumP += pickups[p];
                p--;
            }

            int sumD = 0;
            while (d >= 0) {
                if (sumD + deliveries[d] > cap) {
                    deliveries[d] -= (cap - sumD);
                    break;
                }
                sumD += deliveries[d];
                d--;
            }

        }
        return answer;
    }

}
