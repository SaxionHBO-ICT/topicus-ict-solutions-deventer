package nl.vanlaar.bart.topid.Model;

import android.graphics.Bitmap;

/**
 * Created by bart on 25-5-2016.
 */
public class User {
    private String name;
    private Bitmap profileImage;
    private int tempImage;
    private int postcount;

    public User(String name, Bitmap profileImage, int postcount) {
        this.name = name;
        this.profileImage = profileImage;
        this.postcount = postcount;
    }

    public User(String name, int tempImage) {
        this.name = name;
        this.tempImage = tempImage;
    }

    public User(String name, Bitmap profileImage) {
        this.name = name;
        this.profileImage = profileImage;
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
}
