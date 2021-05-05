package com.jsk.mylogue.main.vo;

public class memberVo {

    String mbrNum;
    String userId;
    String userPwd;
    String newUserPwd;
    String nickName;
    String question;
    String answer;
    String email;
    String email1;
    String email2;

    public String getMbrNum() { return mbrNum; }

    public void setMbrNum(String mbrNum) { this.mbrNum = mbrNum; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNewUserPwd() { return newUserPwd; }

    public void setNewUserPwd(String newUserPwd) { this.newUserPwd = newUserPwd; }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
}