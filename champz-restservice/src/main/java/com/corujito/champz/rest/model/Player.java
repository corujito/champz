package com.corujito.champz.rest.model;

import java.util.Date;
import java.util.List;

public class Player extends BaseDomain {

    private String fullName;
    private String popularName;
    private Date birth;
    private User user;
    private Location birthLocation;
    private String photoImage;
    private List<Passage> passages;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPopularName() {
        return popularName;
    }

    public void setPopularName(String popularName) {
        this.popularName = popularName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(Location birthLocation) {
        this.birthLocation = birthLocation;
    }

    public String getPhotoImage() {
        return photoImage;
    }

    public void setPhotoImage(String photoImage) {
        this.photoImage = photoImage;
    }

    public List<Passage> getPassages() {
        return passages;
    }

    public void setPassages(List<Passage> passages) {
        this.passages = passages;
    }
}
