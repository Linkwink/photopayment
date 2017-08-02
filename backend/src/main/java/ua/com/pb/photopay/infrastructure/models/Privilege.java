package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Privileges that users can obtain through their roles
 */
@Entity
@Table(name = "privilege")
public class Privilege {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of the privilege
     */
    @Column(nullable = false)
    private String name;

    /**
     * Scope for privilege
     */
    @ManyToOne
    @JoinColumn(name = "scope_id", referencedColumnName = "id")
    private Scope scope;

    public Privilege() {
    }

    public Privilege(String name, Scope scope) {
        this.name = name;
        this.scope = scope;
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

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
