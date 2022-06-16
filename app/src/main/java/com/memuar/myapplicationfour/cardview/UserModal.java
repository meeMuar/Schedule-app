package com.memuar.myapplicationfour.cardview;

public class UserModal {

    // variables for our first name,
    // last name, email and avatar
    private String sub_name;
    private String prof_name;
    private String email;
    private String time;

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String first_name) {
        this.sub_name = first_name;
    }

    public String getProf_name() {
        return prof_name;
    }

    public void setProf_name(String last_name) {
        this.prof_name = last_name;
    }

    public String getCabinet() { return email; }

    public void setCabinet(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String avatar) {
        this.time = avatar;
    }

    public UserModal(String first_name, String last_name, String email, String avatar) {
        this.sub_name = first_name;
        this.prof_name = last_name;
        this.email = email;
        this.time = avatar;
    }
}