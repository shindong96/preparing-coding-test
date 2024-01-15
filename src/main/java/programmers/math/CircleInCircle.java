package programmers.math;

public class CircleInCircle {
    
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;
            long r11 = (long) Math.pow(r1, 2);
            long r22 = (long) Math.pow(r2, 2);

            for (int i = 0; i <= r2; i++) {
                for (int j = 0; j <= i; j++) {
                    long value = (long) Math.pow(i, 2) + (long) Math.pow(j, 2);
                    if (value < r11) {
                        continue;
                    }

                    if (value > r22) {
                        // System.out.println(i+" "+j+" "+value);
                        break;
                    }
                    if (i == j | j == 0) {
                        // System.out.println(i+" "+j);
                        answer += 4L;
                    } else {
                        answer += 8L;
                    }
                }
            }
            // answer += 4*(r2-r1+1);
            return answer;
        }
    }
}
