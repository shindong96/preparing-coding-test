package programmers.simulation;

public class TikTakTok {

    public int solution(String[] boa) {
        int[] count = new int[2];
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boa[i].charAt(j) == 'O') {
                    board[i][j] = 1;
                    count[0]++;
                } else if (boa[i].charAt(j) == 'X') {
                    board[i][j] = 2;
                    count[1]++;
                }
            }
        }

        if (count[1] > count[0] || count[0] - count[1] > 1) {
            return 0;
        }

        int[] bingo = {0, 0};
        bingo[0] = countBingo(board, 1);
        bingo[1] = countBingo(board, 2);

        if (bingo[0] == 1 && bingo[1] == 1) {
            return 0;
        }

        if (bingo[0] > 0 && count[0] - count[1] != 1) {
            return 0;
        }

        if (bingo[1] > 0 && count[0] != count[1]) {
            return 0;
        }

        return 1;
    }

    public int countBingo(int[][] board, int player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                if (board[i][0] == player) {
                    count++;
                }
            }

            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                if (board[0][i] == player) {
                    count++;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == player) {
                count++;
            }
        }

        if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            if (board[2][0] == player) {
                count++;
            }
        }
        return count;
    }
}
