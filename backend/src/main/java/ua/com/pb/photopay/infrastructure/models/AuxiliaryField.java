package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 05.07.2017.
 * Describes additional fields required by application creating
 */
@Entity
@Table(name = "auxiliary_field")
public class AuxiliaryField {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Field name
     */
    @Column(nullable = false)
    private String name;

    /**
     * Field type
     */
    @ManyToOne
    @JoinColumn(name = "fieldtype_id", referencedColumnName = "id")
    private AuxiliaryFieldType fieldType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;


    public AuxiliaryField() {
    }

    public AuxiliaryField(String name, AuxiliaryFieldType fieldType) {
        this.name = name;
        this.fieldType = fieldType;
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

    public AuxiliaryFieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(AuxiliaryFieldType fieldType) {
        this.fieldType = fieldType;
    }
}
