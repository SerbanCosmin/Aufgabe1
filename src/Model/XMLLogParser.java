package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for XML files.
 */
public class XMLLogParser implements LogParser {
    @Override
    public List<Log> parse(String filePath) throws IOException {
        List<Log> logEntries = new ArrayList<>();
        Path file = Path.of(filePath);

        StringBuilder xml = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                xml.append(line.trim());
            }
        }

        String content = xml.toString();
        String[] logs = content.split("</log>");
        for (String log : logs) {
            if (!log.contains("<log>")) continue;
            log = log.substring(log.indexOf("<log>") + 5).trim();

            int id = Integer.parseInt(extractTagValue(log, "Id"));
            String held = extractTagValue(log, "Held");
            String anta = extractTagValue(log, "Antagonist");
            Konftyp k = Konftyp.valueOf(extractTagValue(log, "Konfrontationstyp"));
            String ort = extractTagValue(log, "Ort");
            String datum = extractTagValue(log, "Datum");
            double globeinfluss = Double.parseDouble(extractTagValue(log, "GlobalerEinfluss"));
            logEntries.add(new Log(id, held, anta, k,ort, datum,globeinfluss));
        }
        return logEntries;
    }

    private String extractTagValue(String log, String tagName) {
        String startTag = "<" + tagName + ">";
        String endTag = "</" + tagName + ">";
        int startIndex = log.indexOf(startTag) + startTag.length();
        int endIndex = log.indexOf(endTag);
        return log.substring(startIndex, endIndex).trim();
    }
}