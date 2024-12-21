package org.core.models;

import org.core.bases.SubjectBase;

public class LoadsModel extends SubjectBase {

    private String claveIn;
    private String faults1;
    private String faults2;
    private String faults3;
    private SubjectModel subject;


    public LoadsModel() {super();}

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public String getFaults1() {
        return faults1;
    }

    public void setFaults1(String faults1) {
        this.faults1 = faults1;
    }

    public String getFaults2() {
        return faults2;
    }

    public void setFaults2(String faltas2) {
        this.faults2 = faltas2;
    }

    public String getFaults3() {
        return faults3;
    }

    public void setFaults3(String faults3) {
        this.faults3 = faults3;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }
}
