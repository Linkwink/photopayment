package ua.com.pb.photopay.infrastructure.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents roles that users can be
 */
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority{
    /**
     * Unique role's id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Authority's name
     */
    @Column(nullable = false)
    private String name;


    @Override
    public String getAuthority() {
        return name;
    }

    /**
     * List of the privileges that role gives
     */
    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Privilege.class)
    @JoinTable(name="authority_privilege",
            joinColumns = @JoinColumn(name="authority_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="privilege_id",referencedColumnName = "id"))
    private Set<Privilege> privileges;


    public Authority() {
    }

    public Authority(String name, Set<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
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

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
}
