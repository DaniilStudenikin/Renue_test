import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CsvParser {

    private final String strToMatch;

    private final int indexToMatch;

    public CsvParser(String strToMatch, int indexToMatch) {
        this.strToMatch = strToMatch.toLowerCase();
        this.indexToMatch = indexToMatch;
    }

    public List<String[]> start() {

        BufferedReader reader;
        List<String[]> results = new ArrayList<>();
        {
            try {
                reader = new BufferedReader(new InputStreamReader(
                        Objects.requireNonNull(getClass().getResourceAsStream("/airports.csv" ))
                ));
                while (reader.readLine() != null) {
                    String[] row = reader.readLine().split(",");

                    if (row[indexToMatch].toLowerCase().contains(strToMatch)) {
                        results.add(row);
                    }
                }
            } catch (NullPointerException | IOException e) {
                System.out.println("File not found!");
                e.printStackTrace();
            }
        }
        return results;
    }

}
