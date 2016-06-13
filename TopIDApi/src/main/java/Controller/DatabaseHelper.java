package Controller;

import Model.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import spark.Request;
import spark.Response;

import java.sql.SQLException;

/**
 * Created by bart on 12-6-2016.
 */
public class DatabaseHelper {
    // database variables
    private static DatabaseHelper dbHelper;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/topicusdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";



    // create a connection source to our database
    private ConnectionSource connectionSource;

    // data access objects
    private Dao<Comment,Integer> commentDao;
    private Dao<Idee,Integer> ideeDao;
    private Dao<User,String> userDao;

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
            connectionSource = new JdbcConnectionSource(DB_URL,DB_USERNAME, DB_PASSWORD);
            commentDao = DaoManager.createDao(connectionSource, Comment.class);
            ideeDao = DaoManager.createDao(connectionSource,Idee.class);
            userDao = DaoManager.createDao(connectionSource,User.class);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "    " + e.getErrorCode());
        }
    }

    /**
     * alle get methodes.
     * */
    public User getUserByEmail(String username){
        User user = null;
        try {
            user = userDao.queryForId(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * alle add methodes.
     * */
    public boolean addIdeeToDatabase(Idee idee){
        try {
            ideeDao.create(idee);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * alle update methods.
     * */
    public boolean updateIdeeInDatabase(Idee idee){
        try{
            ideeDao.update(idee);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
