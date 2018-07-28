package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import com.corujito.champz.rest.model.ChampionshipType;

@Document(collection = "championships")
public class ChampionshipEntity extends BaseEntity {

    private String name;
    private String popularName;
    private String description;
    private String imageUrl;
    private String organization;
    private String founded;
    private String webSite;
    private ChampionshipType type;

    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPopularName() {
        return popularName;
    }

    public void setPopularName(String popularName) {
        this.popularName = popularName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public ChampionshipType getType() {
        return type;
    }

    public void setType(ChampionshipType type) {
        this.type = type;
    }

    public ChampionshipEntity withId(String id) {
        setId(id);
        return this;
    }

    public ChampionshipEntity withName(String name) {
        setName(name);
        return this;
    }

    public ChampionshipEntity withPopularName(String popularName) {
        setPopularName(popularName);
        return this;
    }

    public ChampionshipEntity withDescription(String description) {
        setDescription(description);
        return this;
    }

    public ChampionshipEntity withImageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    public ChampionshipEntity withOrganization(String organization) {
        setOrganization(organization);
        return this;
    }

    public ChampionshipEntity withFounded(String founded) {
        setFounded(founded);
        return this;
    }

    public ChampionshipEntity withWebSite(String webSite) {
        setWebSite(webSite);
        return this;
    }

    public ChampionshipEntity withType(ChampionshipType type) {
        setType(type);
        return this;
    }

    public ChampionshipEntity withUserId(String userId) {
        setUserId(userId);
        return this;
    }
}
