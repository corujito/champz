package com.corujito.champz.rest.repository.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntity extends BaseEntity {

    private String name;
    @Indexed(unique = true)
    private String email;
    private String rg;
    private String cpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserEntity withId(String id) {
        setId(id);
        return this;
    }

    public UserEntity withName(String name) {
        setName(name);
        return this;
    }

    public UserEntity withEmail(String email) {
        setEmail(email);
        return this;
    }

    public UserEntity withRg(String rg) {
        setRg(rg);
        return this;
    }

    public UserEntity withCpf(String cpf) {
        setCpf(cpf);
        return this;
    }
}
