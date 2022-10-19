package com.gnome.dto;

import java.util.Date;

public class DvD {
    // declare objects of the following: title, release date, MPAA rating, Director's name, Studio, User rating
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String Studio;
    private String UserRating;

    // implement all of variables
    public DvD(String title, String releaseDate, String MPAARating, String directorName, String Studio, String UserRating) {

        this.title = title;
        this.releaseDate = releaseDate;
        this.MPAARating = MPAARating;
        this.directorName = directorName;
        this.Studio = Studio;
        this.UserRating = UserRating;
    }

    public DvD(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getMPAARating(){
        return MPAARating;
    }

    public void setMPAARating(String MPAARating){
        this.MPAARating = MPAARating;
    }

    public String getDirectorName(){
        return directorName;
    }

    public void setDirectorName(String directorName){
        this.directorName = directorName;
    }

    public String getStudio(){
        return Studio;
    }

    public void setStudio(String Studio){
        this.Studio = Studio;
    }

    public String getUserRating(){
        return UserRating;
    }

    public void setUserRating(String userRating){
        this.UserRating = userRating;
    }
}
