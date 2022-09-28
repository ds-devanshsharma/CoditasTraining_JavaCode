package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {
    @Id@Column(name = "Answer_id") int AnsID;
    @Column(name="Answer")
    String Ans;

    public int getAnsID() {
        return AnsID;
    }

    public void setAnsID(int ansID) {
        AnsID = ansID;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
