package Controller;
import Model.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Controller manages the application logic.
 */
public class Controller {
    private final List<Log> logEntries;

    public Controller(List<Log> logEntries) {
        this.logEntries = logEntries;
    }

    public List<String> getLogsByLetter(String letter) {
        Set<String> uniqueLogs = new HashSet<>();
        for (Log entry : logEntries) {
            String processedLog = entry.getHeld();
            if (processedLog.startsWith(String.valueOf(letter))) {
                uniqueLogs.add(processedLog);
            }
        }
        return new ArrayList<>(uniqueLogs);
    }

    public List<Log> getLogsSortedByX() {
        return logEntries.stream()
                .filter(p -> p.getKonftyp() == Konftyp.Galaktisch)
                .sorted(Comparator.comparing(Log::getDatum))
                .toList();
    }

    public List<Log> getAllLogs() {
        return logEntries.stream()
                .toList();
    }
}
