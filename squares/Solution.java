import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int width = input.nextInt();
        int height = input.nextInt();
        System.out.println(countSquares3(width, height));
    }

    private static int countSquares1(int width, int height) {
        int count = 0;
        for (int level = 0; level < Math.min(width, height); level++) {
            for (int row = 0; row < height - level; row++) {
                for (int col = 0; col < width - level; col++) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countSquares2(int width, int height) {
        int count = 0;
        for (int level = 0; level < Math.min(width, height); level++) {
            count += (width - level) * (height - level);
        }
        return count;
    }

    private static int countSquares3(int width, int height) {
        int min = Math.min(width, height);
        int max = Math.max(width, height);
        return min * (3*max*min + 3*max - min*min + 1) / 6;
    }
}
