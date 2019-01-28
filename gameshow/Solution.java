import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int itemCount = input.nextInt();
        int relationCount = input.nextInt();

        ArrayList<List<Integer>> graph = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < relationCount; i++) {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;
            graph.get(x).add(y);
        }

        int p = input.nextInt() - 1;
        int q = input.nextInt() - 1;
        if (downstream(graph, p, q)) {
            System.out.println("P > Q");
        } else if (downstream(graph, q, p)) {
            System.out.println("Q > P");
        } else {
            System.out.println("?");
        }
    }

    private static boolean downstream(List<List<Integer>> graph, int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current == destination) {
                return true;
            }

            queue.addAll(graph.get(current));
        }

        return false;
    }
}
