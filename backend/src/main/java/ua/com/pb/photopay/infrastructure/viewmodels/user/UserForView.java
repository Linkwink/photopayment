package ua.com.pb.photopay.infrastructure.viewmodels.user;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForView;

import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class UserForView implements ViewModelForView {
    private int id;
    private String name;
    private String ldap;
    private String branch;
    private Set<String> roles;
    private String email;
    private String picture;

    public UserForView() {
    }

    public UserForView(int id, String name, String ldap, String branch, Set<String> roles, String email, String picture) {
        this.id = id;
        this.name = name;
        this.ldap = ldap;
        this.branch = branch;
        this.roles = roles;
        this.email = email;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLdap() {
        return ldap;
    }

    public void setLdap(String ldap) {
        this.ldap = ldap;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
