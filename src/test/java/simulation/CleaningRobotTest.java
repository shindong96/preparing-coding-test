package simulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CleaningRobotTest {

    @Test
    void check1() {
        final CleaningRobot cleaningRobot = new CleaningRobot();
        int[][] example = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        assertThat(cleaningRobot.solution(example, 10))
                .isEqualTo(new int[]{2, 2});
    }

    @Test
    void check2() {
        final CleaningRobot cleaningRobot = new CleaningRobot();
        int[][] example = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        assertThat(cleaningRobot.solution(example, 20))
                .isEqualTo(new int[]{4, 5});
    }

    @Test
    void check3() {
        final CleaningRobot cleaningRobot = new CleaningRobot();
        int[][] example = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        assertThat(cleaningRobot.solution(example, 25))
                .isEqualTo(new int[]{0, 1});
    }

}
