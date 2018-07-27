package com.corujito.champz.rest.repository.entity;

import java.util.Date;
import com.corujito.champz.rest.model.Location;

public class PlayerEntity extends BaseEntity {

    private String fullName;
    private String popularName;
    private Date birth;
    private String userId;
    private Location birthLocation;
    private String photoImage;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
