package programmers;

public class MiningMineral {

    public static int DIAMOND = 0;
    public static int IRON = 1;
    public static int STONE = 2;

    public int mine(int pick, int idx, String[] minerals) {
        int count = 0;
        int score = 0;
        int scoreDia;
        int scoreIron;
        int scoreStone;

        if (pick == DIAMOND) {
            scoreDia = scoreIron = scoreStone = 1;
        } else if (pick == IRON) {
            scoreDia = 5;
            scoreIron = scoreStone = 1;
        } else {
            scoreDia = 25;
            scoreIron = 5;
            scoreStone = 1;
        }

        while (count < 5 && idx + count < minerals.length) {
            if (minerals[idx + count].equals("diamond")) {
                score += scoreDia;
            } else if (minerals[idx + count].equals("iron")) {
                score += scoreIron;
            } else {
                score += scoreStone;
            }
            count++;
        }
        return score;
    }

    public int dfs(int idx, int score, int[] picks, String[] minerals) {
        if (idx >= minerals.length || (picks[DIAMOND] == 0 && picks[IRON] == 0 && picks[STONE] == 0)) {
            return score;
        }
        int answer = Integer.MAX_VALUE;

        if (picks[DIAMOND] > 0) {
            int value = getAnswer(DIAMOND, score, idx, picks, minerals);
            if (answer > value) {
                answer = value;
            }
        }

        if (picks[IRON] > 0) {
            int value = getAnswer(IRON, score, idx, picks, minerals);
            if (answer > value) {
                answer = value;
            }
        }
        if (picks[STONE] > 0) {
            int value = getAnswer(STONE, score, idx, picks, minerals);
            if (answer > value) {
                answer = value;
            }
        }

        return answer;
    }

    private int getAnswer(int pick, int score, final int idx, final int[] picks, final String[] minerals) {
        picks[pick]--;
        int value = dfs(idx + 5, score + mine(pick, idx, minerals), picks, minerals);
        picks[pick]++;
        return value;
    }

    public int solution(int[] picks, String[] minerals) {
        return dfs(0, 0, picks, minerals);
    }
}
