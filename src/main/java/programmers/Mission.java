package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Mission {

    public String[] solution(String[][] plans) {
        final ArrayList<String> answer = new ArrayList<>();
        final ArrayList<Plan> planList = new ArrayList<>();
        final Stack<Plan> uncompletedPlans = new Stack<>();

        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], plan[1], plan[2]));
        }

        Collections.sort(planList);

        for (int i = 0; i < planList.size() - 1; i++) {
            final Plan plan = planList.get(i);
            final Plan nextPlan = planList.get(i + 1);
            int remainTime = plan.calculateRemainTime(nextPlan);
            if (remainTime > 0) {
                answer.add(plan.getName());
                while (remainTime > 0 && !uncompletedPlans.isEmpty()) {
                    final Plan uncompletedPlan = uncompletedPlans.pop();
                    if (uncompletedPlan.canComplete(remainTime)) {
                        answer.add(uncompletedPlan.getName());
                        remainTime = remainTime - uncompletedPlan.duringTime;
                    } else {
                        uncompletedPlan.duringTime -= remainTime;
                        remainTime = 0;
                        uncompletedPlans.push(uncompletedPlan);
                    }
                }
            } else {
                plan.saveRemainTime(nextPlan);
                uncompletedPlans.push(plan);
            }
        }

        answer.add(planList.get(planList.size() - 1).getName());
        while (!uncompletedPlans.isEmpty()) {
            final Plan plan = uncompletedPlans.pop();
            answer.add(plan.getName());
        }

        return answer.toArray(new String[answer.size()]);
    }

    class Plan implements Comparable<Plan> {
        String name;
        int startTime;
        int duringTime;

        public Plan(String name, String startTime, String duringTime) {
            this.name = name;
            this.startTime = convertTime(startTime);
            this.duringTime = Integer.parseInt(duringTime);
        }

        public int convertTime(String startTime) {
            final String[] times = startTime.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }

        public int calculateRemainTime(Plan nextPlan) {
            return nextPlan.startTime - startTime - duringTime;
        }

        public boolean canComplete(int time) {
            return duringTime <= time;
        }

        public void saveRemainTime(final Plan nextPlan) {
            duringTime = duringTime - (nextPlan.startTime - startTime);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(final Plan o) {
            return this.startTime - o.startTime;
        }
    }
}
