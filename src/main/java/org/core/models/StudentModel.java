package org.core.models;

import java.util.ArrayList;

public class StudentModel {

    private static StudentModel instance;
    private boolean accessed;
    private String accessToken;
    private String enrollment;
    private String names;
    private String lastNames;
    private String dni;
    private String grade;
    private String group;
    private String status;
    private ArrayList<LoadsModel> loads;
    private ArrayList<HistoryModel> history;
    private DetailsModel details;

    private StudentModel() {
        this.accessed = false;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public StudentModel setEnrollment(String enrollment) {
        this.enrollment = enrollment;
        return this;
    }

    public String getNames() {
        return names;
    }

    public StudentModel setNames(String names) {
        this.names = names;
        return this;
    }

    public String getLastNames() {
        return lastNames;
    }

    public StudentModel setLastNames(String lastNames) {
        this.lastNames = lastNames;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public StudentModel setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public StudentModel setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public StudentModel setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StudentModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public ArrayList<LoadsModel> getLoads() {
        return loads;
    }

    public StudentModel setLoads(ArrayList<LoadsModel> loads) {
        this.loads = loads;
        return this;
    }

    public ArrayList<HistoryModel> getHistory() {
        return history;
    }

    public StudentModel setHistory(ArrayList<HistoryModel> history) {
        this.history = history;
        return this;
    }

    public DetailsModel getDetails() {
        return details;
    }

    public StudentModel setDetails(DetailsModel details) {
        this.details = details;
        return this;
    }

    public static void setInstance(StudentModel instance) {
        StudentModel.instance = instance;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public StudentModel setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public boolean isAccessed() {
        return accessed;
    }

    public StudentModel setAccessed(boolean accessed) {
        this.accessed = accessed;
        return this;
    }

    public static StudentModel getInstance() {
        if (instance == null) {
            instance = new StudentModel();
        }
        return instance;
    }
}
