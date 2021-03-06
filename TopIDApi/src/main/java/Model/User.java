package Model;



import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

/**
 * Een user
 */
@DatabaseTable(tableName = "Gebruiker")
public class User {
    private String profileImage;
    private int tempImage;
    private ArrayList<Idee> gevolgdeIdeeën = new ArrayList<>();

    //database velden
    @DatabaseField(id = true,canBeNull = false)
    private String email_adres;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField
    private String gebruiker_plaatje_url;
    @DatabaseField
    private int postcount;

    /*
    een lege constructor
     */
    public User() {
    }

    /*
    een constructor
     */
    public User(String name, String profileImage, int postcount) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = postcount;
    }

    /*
    een constructor
     */
    public User(String name, String profileImage) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = 0;
    }

    /*
    een constructor
     */
    public User(String name, int tempImage, int postcount) {
        this.name = name;
        this.tempImage = tempImage;
        this.postcount = postcount;
    }

    /*
    een constructor
     */
    public User(String name) {
        this.name = name;
    }

    /*
    verhoog de users postcount
     */
    public void addToPostcount(){
        this.postcount =+1;
    }

    //getters en setters
    public int getTempImage() {
        return tempImage;
    }

    public void setTempImage(int tempImage) {
        this.tempImage = tempImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getPostcount() {
        return postcount;
    }

    public void setPostcount(int postcount) {
        this.postcount = postcount;
    }

    public ArrayList<Idee> getGevolgdeIdeeën() {
        return gevolgdeIdeeën;
    }

    public String getEmail_adres() {
        return email_adres;
    }

    public void setEmail_adres(String email_adres) {
        this.email_adres = email_adres;
    }

    public String getGebruiker_plaatje_url() {
        return gebruiker_plaatje_url;
    }

    public void setGebruiker_plaatje_url(String gebruiker_plaatje_url) {
        gebruiker_plaatje_url = gebruiker_plaatje_url;
    }
}

