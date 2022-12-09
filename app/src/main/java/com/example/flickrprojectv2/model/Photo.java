package com.example.flickrprojectv2.model;

public class Photo {

    String id;
    String title;
    String datetaken;
    String url_h;


    public Photo() {
    }

    public Photo(String id, String title, String datetaken) {
        this.id = id;
        this.title = title;
        this.datetaken = datetaken;
    }

    public Photo(String id, String title, String datetaken, String url_h) {
        this.id = id;
        this.title = title;
        this.datetaken = datetaken;
        this.url_h = url_h;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatetaken() {
        return datetaken;
    }

    public void setDatetaken(String datetaken) {
        this.datetaken = datetaken;
    }

    public String getUrl_h() {
        return url_h;
    }

    public void setUrl_h(String url_h) {
        this.url_h = url_h;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", datetaken='" + datetaken + '\'' +
                ", url_h='" + url_h + '\'' +
                '}';
    }
}
