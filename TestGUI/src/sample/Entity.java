package sample;

import javafx.beans.property.SimpleStringProperty;

public class Entity {
    private String name, city, state, creditBureau, PEP, foreignIndicator, specialUse;
    private int age, zipCode, creditScore;
    private boolean onlineBanking;

    Entity(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreditBureau() {
        return creditBureau;
    }

    public void setCreditBureau(String creditBureau) {
        this.creditBureau = creditBureau;
    }

    public String getPEP() {
        return PEP;
    }

    public void setPEP(String PEP) {
        this.PEP = PEP;
    }

    public String getForeignIndicator() {
        return foreignIndicator;
    }

    public void setForeignIndicator(String foreignIndicator) {
        this.foreignIndicator = foreignIndicator;
    }

    public String getSpecialUse() {
        return specialUse;
    }

    public void setSpecialUse(String specialUse) {
        this.specialUse = specialUse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public boolean isOnlineBanking() {
        return onlineBanking;
    }

    public void setOnlineBanking(boolean onlineBanking) {
        this.onlineBanking = onlineBanking;
    }
}
