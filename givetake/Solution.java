import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowCount = input.nextInt();
        int columnCount = input.nextInt();
        int[][] grid = new int[rowCount][columnCount];
        int[][] minRequired = new int[rowCount][columnCount];
        
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                grid[row][col] = input.nextInt();
            }
        }

        for (int row = rowCount - 1; row >= 0; row--) {
            for (int col = columnCount - 1; col >= 0; col--) {
                calculateMinRequired(grid, minRequired, row, col);
            }
        }
        
        System.out.println(minRequired[0][0]);
    }
    
    private static void calculateMinRequired(int[][] grid, int[][] memo, int row, int col) {
        int rowCount = memo.length;
        int columnCount = memo[0].length;
        int localCost = -grid[row][col];
        
        if (row + 1 < rowCount && col + 1 < columnCount) {
            memo[row][col] = localCost + Math.min(memo[row + 1][col], memo[row][col + 1]);
        } else if (row + 1 < rowCount) {
            memo[row][col] = localCost + memo[row + 1][col];
        } else if (col + 1 < columnCount) {
            memo[row][col] = localCost + memo[row][col + 1];
        } else {
            memo[row][col] = localCost;
        }
        
        memo[row][col] = Math.max(0, memo[row][col]);
    }
}
