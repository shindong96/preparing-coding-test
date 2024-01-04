package programmers.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 40점 실패 코드
public class BiggestNum {

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            List<Integer> nums = new ArrayList<>();

            for (int number : numbers) {
                nums.add(number);
            }

            Collections.sort(nums, ((num1, num2) -> {
                boolean isFirstBigger = num1 > num2 ? true : false;
                int numm1 = num1;
                int numm2 = num2;
                int count1 = 1;
                int count2 = 1;

                while (numm1 / 10 != 0) {
                    numm1 %= 10;
                    count1++;
                }

                while (numm2 / 10 != 0) {
                    numm2 %= 10;
                    count2++;
                }

                int pow = isFirstBigger ? count2 : count1;

                numm1 = num1;
                numm2 = num2;

                int standard = 1;
                if (numm1 / (int) Math.pow(10, count1 - 1) == numm2 / (int) Math.pow(10, count2 - 1)) {
                    standard = numm1 / (int) Math.pow(10, count1 - 1);
                }

                for (int i = 0; i < pow; i++) {
                    count1--;
                    count2--;

                    if ((int) (numm1 / Math.pow(10, count1)) > (int) (numm2 / Math.pow(10, count2))) {
                        return -1;
                    } else if ((int) (numm1 / Math.pow(10, count1)) < (int) (numm2 / Math.pow(10, count2))) {
                        return 1;
                    }

                    numm1 %= (int) Math.pow(10, count1);
                    numm2 %= (int) Math.pow(10, count2);
                }

                if (isFirstBigger) {
                    count1--;
                    if ((int) (numm1 / Math.pow(10, count1)) >= standard) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    count2--;
                    if ((int) (numm2 / Math.pow(10, count2)) >= standard) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }));

            for (int i = 0; i < nums.size(); i++) {
                answer += nums.get(i);
            }

            return answer;
        }
    }
}
