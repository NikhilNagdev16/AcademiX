package com.academix.academix.model;

public class userCollege {
    users user;
    colleges college;

    public userCollege(users user, colleges college) {
        this.user = user;
        this.college = college;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public colleges getCollege() {
        return college;
    }

    public void setCollege(colleges college) {
        this.college = college;
    }
}
