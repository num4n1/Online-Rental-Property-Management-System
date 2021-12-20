package manager;

import java.sql.Connection;

/**
 * interface for strategy pattern
 */
public interface GenerateReport {
    
    /**
     * gets the report sting value
     * @param dbConnect connection object
     * @return
     */
    public String displayReport(Connection dbConnect);
}
