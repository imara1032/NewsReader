package com.example.happy.newsreader;

/**
 * Created by happy on 11/22/2016.
 */

public class newsItem {
    private String newsHeading;
    private String newsDesc;
    private String newsDescSmall;
    private int imageId;
    private String author;
    private String title;

    public String getNewsHeading() {
        return newsHeading;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public String getNewsDescSmall() {
        return newsDescSmall;
    }

    public int getImageId() {
        return imageId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getTime() {
        return time;
    }

    private String url;
    private String time;

    public newsItem(String newsHeading, String newsDesc, String newsDescSmall, int imageId, String author, String title, String url, String time) {
        this.newsHeading = newsHeading;
        this.newsDesc = newsDesc;
        this.newsDescSmall = newsDescSmall;
        this.imageId = imageId;
        this.author = author;
        this.title = title;
        this.url = url;
        this.time = time;
    }
}
