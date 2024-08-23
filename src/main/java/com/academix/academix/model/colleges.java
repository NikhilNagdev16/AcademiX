package com.academix.academix.model;

public class colleges {
    int college_id;
    String college_name;
    String college_address;
    String college_phone;
    String college_email;
    int noOfClasses;
    String logo;

    public colleges(int college_id, String college_name, String college_address, String college_phone, String college_email, int noOfClasses, String logo) {
        this.college_id = college_id;
        this.college_name = college_name;
        this.college_address = college_address;
        this.college_phone = college_phone;
        this.college_email = college_email;
        this.noOfClasses = noOfClasses;
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getCollege_address() {
        return college_address;
    }

    public void setCollege_address(String college_address) {
        this.college_address = college_address;
    }

    public String getCollege_phone() {
        return college_phone;
    }

    public void setCollege_phone(String college_phone) {
        this.college_phone = college_phone;
    }

    public String getCollege_email() {
        return college_email;
    }

    public void setCollege_email(String college_email) {
        this.college_email = college_email;
    }

    public int getNoOfClasses() {
        return noOfClasses;
    }

    public void setNoOfClasses(int noOfClasses) {
        this.noOfClasses = noOfClasses;
    }
}
