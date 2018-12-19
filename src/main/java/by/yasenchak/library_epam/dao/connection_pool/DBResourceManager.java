package by.yasenchak.library_epam.dao.connection_pool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
