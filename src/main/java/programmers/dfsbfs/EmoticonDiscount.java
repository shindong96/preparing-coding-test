package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmoticonDiscount {
    int[] dC = {40, 30, 20, 10};

    public int[] solution(int[][] users1, int[] emoticons1) {
        int[] answer = new int[2];

        List<User> users = new ArrayList<>();
        List<Emoticon> emoticons = new ArrayList<>();

        for (int[] user : users1) {
            users.add(new User(user[0], user[1]));
        }

        for (int emoticon : emoticons1) {
            emoticons.add(new Emoticon(emoticon, 0));
        }

        Result result = dfs(users, 0, emoticons, new Result(0, 0));
        answer[0] = result.count;
        answer[1] = result.money;
        return answer;
    }

    public Result dfs(List<User> users, int idx, List<Emoticon> emoticons, Result result) {
        if (idx == emoticons.size()) {
            int count = 0;
            int money = 0;
            Collections.sort(users);
            int[] usedMoney = new int[users.size()];

            for (Emoticon emoticon : emoticons) {
                for (int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
                    if (emoticon.discount < user.percentage) {
                        break;
                    }
                    usedMoney[i] += emoticon.calculate();
                }
            }

            for (int i = 0; i < users.size(); i++) {
                if (usedMoney[i] >= users.get(i).money) {
                    count++;
                } else {
                    money += usedMoney[i];
                }
            }

            Result newResult = new Result(count, money);
            return result.isBiggerThan(newResult) ? result : newResult;
        }

        for (int i = 0; i < 4; i++) {
            Emoticon emoticon = emoticons.get(idx);
            emoticon.discount = dC[i];
            result = dfs(users, idx + 1, emoticons, result);
        }

        return result;
    }

    class User implements Comparable<User> {
        int percentage;
        int money;

        public User(int percentage, int money) {
            this.percentage = percentage;
            this.money = money;
        }

        @Override
        public int compareTo(User other) {
            if (percentage >= other.percentage) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    class Emoticon {
        int price;
        int discount;

        public Emoticon(int price, int discount) {
            this.price = price;
            this.discount = discount;
        }

        public int calculate() {
            return price / 100 * (100 - discount);
        }
    }

    class Result {
        int count;
        int money;

        public Result(int count, int money) {
            this.count = count;
            this.money = money;
        }

        public boolean isBiggerThan(Result other) {
            if (count > other.count) {
                return true;
            } else if (count == other.count) {
                if (money > other.money) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
