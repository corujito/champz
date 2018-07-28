package com.corujito.champz.rest.repository.entity;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.Location;

@Document(collection = "players")
public class PlayerEntity extends BaseEntity {

    private String fullName;
    private String popularName;
    private String nickName;
    private String rg;
    private String cpf;
    private Date birth;
    private Location birthLocation;
    private String photoImage;

    private String userId;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PlayerEntity withId(String id) {
        setId(id);
        return this;
    }

    public PlayerEntity withFullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public PlayerEntity withPopularName(String popularName) {
        setPopularName(popularName);
        return this;
    }

    public PlayerEntity withNickName(String nickName) {
        setNickName(nickName);
        return this;
    }

    public PlayerEntity withRg(String rg) {
        setRg(rg);
        return this;
    }

    public PlayerEntity withCpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public PlayerEntity withBirth(Date birth) {
        setBirth(birth);
        return this;
    }

    public PlayerEntity withUserId(String userId) {
        setUserId(userId);
        return this;
    }

    public PlayerEntity withBirthLocation(Location birthLocation) {
        setBirthLocation(birthLocation);
        return this;
    }

    public PlayerEntity withPhotoImage(String photoImage) {
        setPhotoImage(photoImage);
        return this;
    }
}
