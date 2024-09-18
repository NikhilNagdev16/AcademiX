package com.academix.academix.model;

public class attendancemodel {
    int userid;
    int rollno;
    boolean status;


    public attendancemodel(int userid, int rollno, boolean status) {
        this.userid = userid;
        this.rollno = rollno;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
