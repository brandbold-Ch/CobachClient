package org.core.models;

import org.core.bases.SubjectBase;

public class HistoryModel extends SubjectBase {

    private String grade;
    private String group;
    private String keyMat;
    private String subject;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getKeyMat() {
        return keyMat;
    }

    public void setKeyMat(String keyMat) {
        this.keyMat = keyMat;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
