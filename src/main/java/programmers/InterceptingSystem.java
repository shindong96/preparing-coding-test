package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class InterceptingSystem {

    public static void main(String[] args) {
        final InterceptingSystem interceptingSystem = new InterceptingSystem();
        int[][] ints = new int[3][];
        ints[0] = new int[]{1, 4};
        ints[1] = new int[]{1, 5};
        ints[2] = new int[]{1, 3};
        interceptingSystem.solution(ints);
        System.out.println();
    }

    public int solution(int[][] targets) {
        final ArrayList<Missile> interceptingMissiles = new ArrayList<>();
        final ArrayList<Missile> missiles = new ArrayList<>();

        for (int[] target : targets) {
            missiles.add(new Missile(target[0], target[1]));
        }
        Collections.sort(missiles);

        for (Missile missile : missiles) {
            boolean canIntercept = false;
            for (Missile interceptingMissile : interceptingMissiles) {
                if (interceptingMissile.canIntercept(missile)) {
                    interceptingMissile.setMin(Math.max(interceptingMissile.min, missile.min));
                    interceptingMissile.setMax(Math.min(interceptingMissile.max, missile.max));
                    canIntercept = true;
                    break;
                }
            }

            if (!canIntercept) {
                interceptingMissiles.add(missile);
            }
        }

        for (Missile interceptingMissile : interceptingMissiles) {
            System.out.println("(" + interceptingMissile.min + "," + interceptingMissile.max + ")");
        }
        return interceptingMissiles.size();
    }

    class Missile implements Comparable<Missile> {

        int min;
        int max;

        public Missile(final int min, final int max) {
            this.min = min;
            this.max = max;
        }

        public boolean canIntercept(Missile missile) {
            return !(this.max <= missile.min || this.min >= missile.max);
        }

        public int getSize() {
            return max - min;
        }

        public void setMin(final int min) {
            this.min = min;
        }

        public void setMax(final int max) {
            this.max = max;
        }

        @Override
        public int compareTo(final Missile missile) {
            return Integer.compare(this.getSize(), missile.getSize());
        }
    }
}
