package SO;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private List<String> log;

    public Journal() {
        this.log = new ArrayList<>();
    }

    public void log(String operation, String details) {
        log.add(operation + ": " + details);
    }

    public List<String> getLog() {
        return log;
    }
}