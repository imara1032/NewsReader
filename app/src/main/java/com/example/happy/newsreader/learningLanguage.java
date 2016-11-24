package com.example.happy.newsreader;

/**
 * Created by happy on 11/22/2016.
 */

public class learningLanguage {
    private String nameLang;
    private int imageId;
    private int NumberOfTutorils;

    public String getNameLang() {
        return nameLang;
    }

    public void setNameLang(String nameLang) {
        this.nameLang = nameLang;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTutorialNumber() {
        return NumberOfTutorils;
    }

    public void setTutorialNumber(int tutorialNumber) {
        this.NumberOfTutorils = tutorialNumber;
    }

    public learningLanguage(String nameLang, int imageId, int tutorialNumber) {
        this.nameLang = nameLang;
        this.imageId = imageId;
        this.NumberOfTutorils = tutorialNumber;
    }
}
