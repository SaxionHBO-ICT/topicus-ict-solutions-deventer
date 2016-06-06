package nl.vanlaar.bart.topid.Model;

import android.graphics.Bitmap;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by bart on 25-5-2016.
 */
public class User {
    private String name;
    private int profileImage;
    private int tempImage;
    private int postcount;
    private ArrayList<Idee> gevolgeIdeeën = new ArrayList<>();

    public User(String name, int profileImage, int postcount) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = postcount;
    }

    public User(String name, int profileImage) {
        this.name = name;
        this.profileImage = profileImage;
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

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
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

    public Bundle toBundle(){
        Bundle b = new Bundle();



        return b;
    }

    public ArrayList<Idee> getGevolgeIdeeën() {
        return gevolgeIdeeën;
    }
}

