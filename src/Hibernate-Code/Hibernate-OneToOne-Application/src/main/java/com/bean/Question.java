package com.bean;

import javax.persistence.*;

@Entity
public class Question {
    @Id@Column(name = "Ques_id") private int QuesID;
    @Column(name="Question")
    private String Ques;
    @OneToOne@JoinColumn(name = "a_id")
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getQuesID() {
        return QuesID;
    }

    public void setQuesID(int quesID) {
        QuesID = quesID;
    }

    public String getQues() {
        return Ques;
    }

    public void setQues(String ques) {
        Ques = ques;
    }

    @Override
    public String toString() {
        return "Question{" +
                "QuesID=" + QuesID +
                ", Ques='" + Ques + '\'' +
                ", answer=" + answer +
                '}';
    }
}
