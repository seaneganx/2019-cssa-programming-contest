import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int segmentCount = input.nextInt();
        int queryCount = input.nextInt();

        List<Line> segments = new ArrayList<>();
        for (int i = 0; i < segmentCount; i++) {
            Point a = new Point(input.nextInt(), input.nextInt());
            Point b = new Point(input.nextInt(), input.nextInt());
            if (a.x == b.x) {
                segments.add(new Line(a, b));
            }
        }
        
        for (int i = 0; i < queryCount; i++) {
            Point query = new Point(input.nextInt() + 0.5, input.nextInt() + 0.5);
            long count = segments.stream()
                .filter(segment -> segment.upper.x > query.x)
                .filter(segment -> segment.upper.y > query.y)
                .filter(segment -> segment.lower.y < query.y)
                .count();

            if (count % 2 == 0) {
                System.out.println("OUT OF RANGE");
            } else {
                System.out.println("IN RANGE");
            }
        }
    }
}

class Point {
    public final double x;
    public final double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    public final Point lower;
    public final Point upper;
    public Line(Point a, Point b) {
        this.lower = (a.y < b.y) ? a : b;
        this.upper = (a.y < b.y) ? b : a;
    }
}
