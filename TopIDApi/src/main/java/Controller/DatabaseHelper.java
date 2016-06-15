package Controller;

import Model.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bart on 12-6-2016.
 */
public class DatabaseHelper {
    // database variables
    private static DatabaseHelper dbHelper;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/topicusdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "usbw";



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

    public Idee getIdeeById(int id){
        Idee idee = null;
        try {
            idee = ideeDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idee;
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

    public boolean addUserToDatabase(User gebruiker){
        try {
            userDao.create(gebruiker);
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

    public boolean upvoteIdee(Idee idee, User user){
        idee.like();///////////////////////////////////////////////////////////////////////////////////////////////////////////
        return true;
    }

    public ArrayList<Idee> getNieuwsteIdeeën(boolean isIdee){
        try {
            List<Idee> list = ideeDao.queryForAll();
            ArrayList<Idee> ideeën = new ArrayList<>();
            ideeën.addAll(list);
            for (Idee idee: ideeën){
                if (isIdee){
                    if (idee.getIdee_cat() == 1){
                        ideeën.remove(idee);
                    }
                } else {
                    if (idee.getIdee_cat() == 2){
                        ideeën.remove(idee);
                    }
                }
            }
            ideeën = customNieuwsteIdeeënSorter(ideeën);
            return ideeën;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Idee> getBesteIdeeën(boolean isIdee){
        try{
            List<Idee> list = ideeDao.queryForAll();
            ArrayList<Idee> ideeën = new ArrayList<>();
            ideeën.addAll(list);
            for (Idee idee: ideeën){
                if (isIdee){
                    if (idee.getIdee_cat() == 1){
                        ideeën.remove(idee);
                    }
                } else {
                    if (idee.getIdee_cat() == 2){
                        ideeën.remove(idee);
                    }
                }
            }
            ideeën = customBesteIdeeënSorter(ideeën);
            return ideeën;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Idee> customBesteIdeeënSorter(ArrayList<Idee> ideeën){
        ArrayList<Idee> gesorteerdeIdeeën = ideeën;
        boolean aangepast = true;
        while (aangepast) {
            int changeCounter = 0;
            for (int i = 0; i < gesorteerdeIdeeën.size(); i++) {
                if (gesorteerdeIdeeën.get(i).getIdee_points() < gesorteerdeIdeeën.get(i + 1).getIdee_points()) {
                    Idee idee = gesorteerdeIdeeën.get(i);
                    gesorteerdeIdeeën.remove(i);
                    gesorteerdeIdeeën.add(i + 1, idee);
                    changeCounter++;
                }
            }
            if (changeCounter == 0){
                aangepast = false;
            }
        }
        return gesorteerdeIdeeën;
    }

    private ArrayList<Idee> customNieuwsteIdeeënSorter(ArrayList<Idee> ideeën){
        ArrayList<Idee> gesorteerdeIdeeën = ideeën;
        boolean aangepast = true;
        while (aangepast) {
            int changeCounter = 0;
            for (int i = 0; i < gesorteerdeIdeeën.size(); i++) {
                if (gesorteerdeIdeeën.get(i).getIdee_datum().compareTo(gesorteerdeIdeeën.get(i + 1).getIdee_datum()) > 1) {
                    Idee idee = gesorteerdeIdeeën.get(i);
                    gesorteerdeIdeeën.remove(i);
                    gesorteerdeIdeeën.add(i + 1, idee);
                    changeCounter++;
                }
            }
            if (changeCounter == 0){
                aangepast = false;
            }
        }
        return gesorteerdeIdeeën;
    }
}
