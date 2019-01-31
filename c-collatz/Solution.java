public class Solution {
    public static void main(String[] args) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        
        for (int prime : primes) {
            int count = 0;
            while (prime > 1) {
                prime = (prime % 2 == 0) ? (prime / 2) : (3*prime + 1);
                count++;
            }
            System.out.println(count);
        }
    }
}
