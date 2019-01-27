import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeMap<Integer, Integer> tasks = new TreeMap<>();
        
        while (input.hasNextLine()) {
            String[] tokens = input.nextLine().split(" ");
            String cmd = tokens[0];

            if ("i".equals(cmd)) {
                insert(tasks, tokens);
            } else if ("f".equals(cmd)) {
                System.out.println(find(tasks, tokens));
            } else if ("r".equals(cmd)) {
                System.out.println(remove(tasks, tokens));
            }
        }
    }

    private static void insert(TreeMap<Integer, Integer> tasks, String[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            int task = Integer.parseInt(tokens[i]);
            if (tasks.containsKey(task)) {
                int count = tasks.get(task);
                tasks.put(task, count + 1);
            } else {
                tasks.put(task, 1);
            }
        }
    }

    private static int find(TreeMap<Integer, Integer> tasks, String[] tokens) {
        return ("min".equals(tokens[1])) ? tasks.firstKey() : tasks.lastKey();
    }

    private static int remove(TreeMap<Integer, Integer> tasks, String[] tokens) {
        int task = find(tasks, tokens);
        int count = tasks.get(task);
        if (count > 1) {
            tasks.put(task, count - 1);
        } else {
            tasks.remove(task);
        }

        return task;
    }
}
