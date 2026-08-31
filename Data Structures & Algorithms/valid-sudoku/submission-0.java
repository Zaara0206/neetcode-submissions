
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char num = board[i][j];

                // Check row
                String row = num + "row" + i;

                // Check column
                String col = num + "col" + j;

                // Check 3x3 box
                String box = num + "box" + (i / 3) + "-" + (j / 3);

                if (!set.add(row) || !set.add(col) || !set.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
}
