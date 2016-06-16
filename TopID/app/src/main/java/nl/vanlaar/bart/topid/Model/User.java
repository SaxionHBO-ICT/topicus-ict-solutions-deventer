package nl.vanlaar.bart.topid.Model;

import android.graphics.Bitmap;
import android.os.Bundle;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.R;

/**
 * Een user object
 */
public class User {
    private String name;
    private Bitmap profileImage;
    private int tempImage = R.drawable.anoniem;
    private int postcount;
    private ArrayList<Idee> gevolgdeIdeeën = new ArrayList<>();

    /*
    een constructor
     */
    public User(String name, Bitmap profileImage, int postcount) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = postcount;
    }

    /*
    een constructor
     */
    public User(String name, Bitmap profileImage) {
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
    getters en setters
     */
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

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
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

    /*
    verhoog postcount met 1
     */
    public void addToPostcount() {
        this.postcount = +1;
    }
}

