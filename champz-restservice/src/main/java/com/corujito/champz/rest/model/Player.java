package com.corujito.champz.rest.model;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Player {

    @NotNull(groups = {Existing.class, PlayerTeamPassage.New.class, PlayerTeamPassage.Existing.class,
            PlayerMatchAttendance.New.class, PlayerMatchAttendance.Existing.class, PlayerInscription.New.class,
            PlayerInscription.Existing.class})
    @Null(groups = New.class)
    private String id;

    @NotNull(groups = {Existing.class, New.class})
    @NotBlank
    private String fullName;
    private String popularName;
    private String nickName;
    private String rg;
    private String cpf;
    private Date birth;
    private Location birthLocation;
    private String photoImage;

    @NotNull(groups = {Existing.class, New.class})
    @Valid
    private User user;
    private List<PlayerTeamPassage> passages;
    private List<PlayerInscription> inscriptions;

    public interface Existing {
    }

    public interface New {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<PlayerTeamPassage> getPassages() {
        return passages;
    }

    public void setPassages(List<PlayerTeamPassage> passages) {
        this.passages = passages;
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

    public List<PlayerInscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<PlayerInscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Player withId(String id) {
        setId(id);
        return this;
    }

    public Player withFullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public Player withPopularName(String popularName) {
        setPopularName(popularName);
        return this;
    }

    public Player withNickName(String nickName) {
        setNickName(nickName);
        return this;
    }

    public Player withRg(String rg) {
        setRg(rg);
        return this;
    }

    public Player withCpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Player withBirth(Date birth) {
        setBirth(birth);
        return this;
    }

    public Player withUser(User user) {
        setUser(user);
        return this;
    }

    public Player withBirthLocation(Location birthLocation) {
        setBirthLocation(birthLocation);
        return this;
    }

    public Player withPhotoImage(String photoImage) {
        setPhotoImage(photoImage);
        return this;
    }

    public Player withPassages(List<PlayerTeamPassage> passages) {
        setPassages(passages);
        return this;
    }

    public Player withInscriptions(List<PlayerInscription> inscriptions) {
        setInscriptions(inscriptions);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("fullName", this.fullName)
                .append("popularName", this.popularName)
                .append("nickName", this.nickName)
                .append("birth", this.birth)
                .append("birthLocation", this.birthLocation)
                .append("cpf", this.cpf)
                .append("rg", this.rg)
                .append("inscriptions", this.inscriptions)
                .append("passages", this.passages)
                .append("photoImage", this.photoImage)
                .append("photoImage", this.photoImage)
                .append("user", this.user)
                .toString();
    }
}
