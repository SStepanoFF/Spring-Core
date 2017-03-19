package epam.loggers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import epam.Event;

public class FileEventLogger implements IEventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean init() throws IOException {
        return file.canWrite();
    }
}
