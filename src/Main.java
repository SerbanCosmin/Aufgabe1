import java.util.List;
import Model.JSONLogParser;
import Model.LogParser;
import Model.Log;
import Model.LogParserFactory;
import Controller.Controller;
import UI.UI;
/**
 * Main program class
 */
public class Main {
    public static void main(String[] args) {
        try {
            LogParser parser = LogParserFactory.getParser("tsv");
            List<Log> logEntries = parser.parse("src/marvel_konfrontationen.tsv");

            Controller controller = new Controller(logEntries);
            UI ui = new UI(controller);

            ui.menu();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}