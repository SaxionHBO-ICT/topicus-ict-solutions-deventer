package nl.vanlaar.bart.topid.Database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by bart on 12-6-2016.
 */
public class DatabaseHelper {

    private static DatabaseHelper dbHelper;
    private static final String DB_URL = "jbdc:mysql://127.0.0.1:3306/topicusdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    // create a connection source to our databse
    private ConnectionSource connectionSource;

    private DatabaseHelper(){
        initializeDatabaseLink();
    }

    public static DatabaseHelper getInstance(){
        if(dbHelper == null){
            dbHelper = new DatabaseHelper();
        }
        return dbHelper;
    }


    private void initializeDatabaseLink(){
        try {
            connectionSource = new JdbcConnectionSource(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "    " + e.getErrorCode());
        }
    }
}
