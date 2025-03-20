import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Exceptions extends Exception {
    private static final Logger logger = Logger.getLogger(Exceptions.class.getName());
    public Exceptions(String message) {
        super(message);
        // Configure logging to write to a file
        try {
            FileHandler fileHandler = new FileHandler("error.log", true); // Append to existing log file if it exists
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Log the exception
        logger.log(Level.SEVERE, message, this);
    }
    public Exceptions() {
        super();
    }
}