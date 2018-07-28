package com.corujito.champz.rest.model;

public class User extends BaseDomain {

    private String name;
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

    public User withId(String id) {
        setId(id);
        return this;
    }

    public User withName(String name) {
        setName(name);
        return this;
    }

    public User withEmail(String email) {
        setEmail(email);
        return this;
    }

    public User withRg(String rg) {
        setRg(rg);
        return this;
    }

    public User withCpf(String cpf) {
        setCpf(cpf);
        return this;
    }
}
