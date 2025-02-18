package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for TSV files.
 */
public class TSVLogParser implements LogParser {
    @Override
    public List<Log> parse(String filePath) throws IOException {
        List<Log> logEntries = new ArrayList<>();
        Path file = Path.of(filePath);

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            reader.readLine(); // Ignore header row
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");

                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0].trim());
                    String held = parts[1].trim();
                    String antagonist = parts[2].trim();
                    Konftyp konftyp = Konftyp.valueOf(parts[3].trim());
                    String ort = parts[4].trim();
                    String datum = parts[5].trim();
                    double globeeinfluss = Double.parseDouble(parts[6].trim());

                    logEntries.add(new Log(id, held, antagonist,konftyp, ort, datum,globeeinfluss));
                }
            }
        }
        return logEntries;
    }
}
