import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("String please: ");

        String strToMatch = scanner.nextLine();

        long start = System.currentTimeMillis();

        CsvParser parser = new CsvParser(strToMatch, args.length == 0 ? 1 : Integer.parseInt(args[0]));

        List<String[]> result = parser.start();

        result.forEach(row -> System.out.println(Arrays.toString(row)));

        System.out.println("Results count: " + result.size() + "!");

        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
