import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterWithLoop(List<Bogie> list) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterWithStream(List<Bogie> list) {
        return list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("==============================================\n");

        // Create dataset
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Bogie" + i, (i % 100) + 1));
        }

        // Loop timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies);
        long endLoop = System.nanoTime();

        // Stream timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies);
        long endStream = System.nanoTime();

        long loopTime = endLoop - startLoop;
        long streamTime = endStream - startStream;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}