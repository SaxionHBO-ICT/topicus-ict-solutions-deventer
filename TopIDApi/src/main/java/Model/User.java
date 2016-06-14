package Model;



import com.j256.ormlite.field.DatabaseField;

import java.util.ArrayList;

/**
 * Created by bart on 25-5-2016.
 */
public class User {
    private String name;
    private String email_adres;
    private String profileImage;
    private int tempImage;
    private int postcount;
    private ArrayList<Idee> gevolgdeIdeeën = new ArrayList<>();

    @DatabaseField(id = true)
    private String Email_adres;
    @DatabaseField(canBeNull = false)
    private String Gebruikersnaam;
    @DatabaseField(canBeNull = false)
    private String Wachtwoord;
    @DatabaseField
    private String Gebruiker_plaatje_url;

    public User() {
    }

    public User(String name, String profileImage, int postcount) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = postcount;
    }

    public User(String name, String profileImage) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = 0;
    }

    public User(String name, int tempImage, int postcount) {
        this.name = name;
        this.tempImage = tempImage;
        this.postcount = postcount;
    }

    public User(String name) {
        this.name = name;
    }

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
    public void addToPostcount(){
        this.postcount =+1;
    }


    public ArrayList<Idee> getGevolgdeIdeeën() {
        return gevolgdeIdeeën;
    }

    public String getEmail_adres() {
        return Email_adres;
    }

    public void setEmail_adres(String email_adres) {
        this.Email_adres = email_adres;
    }

    public String getGebruiker_plaatje_url() {
        return Gebruiker_plaatje_url;
    }

    public void setGebruiker_plaatje_url(String gebruiker_plaatje_url) {
        Gebruiker_plaatje_url = gebruiker_plaatje_url;
    }
}

