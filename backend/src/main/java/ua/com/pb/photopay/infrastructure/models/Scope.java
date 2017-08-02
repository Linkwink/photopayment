package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Entity
@Table(name = "scope")
public class Scope implements BaseModel {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of the scope
     */
    @Column(nullable = false)
    private String name;

    public Scope() {
    }

    public Scope(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
