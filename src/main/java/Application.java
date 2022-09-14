import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Date;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws NotFoundException {
        logger.info("Application started at " + new Date());
        new InteractiveInterface().run();
    }
}
