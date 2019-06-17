package com.nkhatho.leole.doggyparlour;


public class Dog {

    private String dogName;
    private int dogAge;
    private String dogBreed;
    private String dogStatus;
    private String dogBreedInfo;

    public Dog(String dogName, int dogAge, String dogBreed, String dogStatus, String dogBreedInfo) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
        this.dogStatus = dogStatus;
        this.dogBreedInfo = dogBreedInfo;
    }

    public String getDogName() {
        return dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public String getDogStatus() {
        return dogStatus;
    }

    public String getDogBreedInfo(){
        return  dogBreedInfo;
    }






}
