package com.corujito.champz.rest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {

    @NotNull(groups = {User.Existing.class, Player.New.class, Player.Existing.class, Championship.New.class,
            Championship.Existing.class})
    @Null(groups = User.New.class)
    private String id;

    @NotNull(groups = {User.Existing.class, User.New.class})
    private String name;

    @NotNull(groups = {User.Existing.class, User.New.class})
    @NotBlank
    @Email
    private String email;

    private String rg;
    private String cpf;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        User rhs = (User) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(id, rhs.id)
                .append(name, rhs.name)
                .append(email, rhs.email)
                .append(cpf, rhs.cpf)
                .append(rg, rhs.rg)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(email)
                .append(cpf)
                .append(rg)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", this.id)
                .append("name", this.name)
                .append("email", this.email)
                .append("cpf", this.cpf)
                .append("rg", this.rg)
                .toString();
    }
}
