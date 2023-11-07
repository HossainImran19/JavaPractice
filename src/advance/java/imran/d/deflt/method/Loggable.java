package advance.java.imran.d.deflt.method;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public interface Loggable {
    Logger getLogger();
    String getDelimiter();
    void log(Level level, String msg);
    default void info(String msg,
                      Object... objects) {
        getLogger().log(new LogRecord(Level.INFO, formateMsg(msg, objects)));
    }

    default void error(String msg,
                       Object... objects) {
        getLogger().log(new LogRecord(Level.SEVERE, formateMsg(msg, objects)));
    }

    // Here we will use private method to reduce duplicate code
    // When a default method becomes too large,
    // private methods are used to break it down into smaller private methods.
    // The code of formateMsg() is shared to the default method of error() and info().
    private String formateMsg(String msg,
                              Object... objects) {

        StringBuilder sbMsg = new StringBuilder(msg);
        for (Object object : objects) {
            int index = sbMsg.indexOf(getDelimiter());

            if (index == -1)
                break;

            sbMsg.replace(
                    index,
                    index + getDelimiter().length(),
                    object == null ? "null" : object.toString()
            );
        }
        return sbMsg.toString();
    }
}
