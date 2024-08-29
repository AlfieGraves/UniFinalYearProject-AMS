
package model;

import javax.swing.Icon;

public class Model_User {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Icon getProfile() {
        return profile;
    }

    public void setProfile(Icon profile) {
        this.profile = profile;
    }

    public Model_User(int userID, String userName, Icon profile) {
        this.userID = userID;
        this.userName = userName;
        this.profile = profile;
    }

    public Model_User() {
    }

    private int userID;
    private String userName;
    private Icon profile;
}

