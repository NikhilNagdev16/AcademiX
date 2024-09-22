package com.academix.academix.model;

public class examModel {
    int userid;
    int rollno;
    int internal;
    int external;
    int practical;

    public examModel(int userid, int rollno, int internal, int external, int practical) {
        this.userid = userid;
        this.rollno = rollno;
        this.internal = internal;
        this.external = external;
        this.practical = practical;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public int getExternal() {
        return external;
    }

    public void setExternal(int external) {
        this.external = external;
    }

    public int getPractical() {
        return practical;
    }

    public void setPractical(int practical) {
        this.practical = practical;
    }
}
