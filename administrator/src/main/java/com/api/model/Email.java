package com.api.model;

public class Email {
    public String ToUser;
    public String Subject;
    public String Content;

    public Email() {}

    public Email(String toUser, String subject, String content) {
        ToUser = toUser;
        Subject = subject;
        Content = content;
    }

    public String getToUser() {
        return ToUser;
    }

    public void setToUser(String toUser) {
        ToUser = toUser;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
