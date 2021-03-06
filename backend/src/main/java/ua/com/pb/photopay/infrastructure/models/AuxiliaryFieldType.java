package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by dn110592kvo on 05.07.2017.
 * Describes auxiliary field type
 */
@Entity
@Table(name = "auxiliary_field_type")
public class AuxiliaryFieldType implements BaseModel {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Type name
     */
    @Column(nullable = false)
    private String name;


    public AuxiliaryFieldType() {
    }

    public AuxiliaryFieldType(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
