package simulation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class ClimbingLadderTest {

    @Test
    void check() {
        final ClimbingLadder climbingLadder = new ClimbingLadder();

        assertAll(
                () -> assertThat(climbingLadder.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}))
                        .isEqualTo(new char[]{'D', 'B', 'A', 'C', 'E'}),
                () -> assertThat(climbingLadder.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}}))
                        .isEqualTo(new char[]{'A', 'C', 'B', 'F', 'D', 'G', 'E'}),
                () -> assertThat(climbingLadder.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}}))
                        .isEqualTo(new char[]{'C', 'A', 'B', 'F', 'D', 'E', 'H', 'G'}),
                () -> assertThat(climbingLadder.solution(12,
                        new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}}))
                        .isEqualTo(new char[]{'C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H'})
        );
    }
}
