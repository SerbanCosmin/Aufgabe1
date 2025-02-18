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



    public List<Log> getAllLogs() {
        return logEntries.stream()
                .toList();
    }
}
