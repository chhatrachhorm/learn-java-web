package data;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionHolder implements HttpSessionBindingListener {
    private Connection connection;

    public ConnectionHolder(Connection connection){
        this.connection = connection;
        try{
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        // Do nothing when added to a Session
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        // Roll back changes when removed from a Session
        // (or when the Session expires)
        try {
            if (connection != null) {
                connection.rollback();  // abandon any uncomitted data
                connection.close();
            }
        }
        catch (SQLException e) {
            // Report it
        }
    }

}
