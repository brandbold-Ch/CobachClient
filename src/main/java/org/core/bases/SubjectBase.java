package org.core.bases;

public abstract class SubjectBase {
    protected String enrollment;
    protected String claveMat;
    protected String partial1;
    protected String partial2;
    protected String partial3;
    protected String average;
    protected String observation;
    protected String word;

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getClaveMat() {
        return claveMat;
    }

    public void setClaveMat(String claveMat) {
        this.claveMat = claveMat;
    }

    public String getPartial1() {
        return partial1;
    }

    public void setPartial1(String partial1) {
        this.partial1 = partial1;
    }

    public String getPartial2() {
        return partial2;
    }

    public void setPartial2(String partial2) {
        this.partial2 = partial2;
    }

    public String getPartial3() {
        return partial3;
    }

    public void setPartial3(String partial3) {
        this.partial3 = partial3;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
