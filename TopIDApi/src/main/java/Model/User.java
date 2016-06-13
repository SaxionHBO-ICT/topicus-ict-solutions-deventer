package Model;



import java.util.ArrayList;

/**
 * Created by bart on 25-5-2016.
 */
public class User {
    private String name;
    private String profileImage;
    private int tempImage;
    private int postcount;
    private ArrayList<Idee> gevolgdeIdeeën = new ArrayList<>();

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
}

