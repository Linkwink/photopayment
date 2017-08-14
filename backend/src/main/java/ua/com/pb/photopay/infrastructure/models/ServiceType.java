package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents type of service
 */
@Entity
@Table(name = "service_type")
public class ServiceType extends ImageHolder {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Service type name
     */
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "auxiliaryFields",
            joinColumns = @JoinColumn(name = "servicetype_id", referencedColumnName = "id", table = "service_type"),
            inverseJoinColumns = @JoinColumn(name = "auxiliaryfield_id", referencedColumnName = "id", table = "auxiliary_field"))
    private Set<AuxiliaryField> auxiliaryFields;

    @ManyToOne
    private ServiceGroup serviceGroup;


    private String serviceNomenklature;


    public ServiceType() {
    }

    public ServiceType(String name, Set<AuxiliaryField> auxiliaryFields, ServiceGroup serviceGroup, String serviceNomenklature) {
        this.name = name;
        this.auxiliaryFields = auxiliaryFields;
        this.serviceGroup = serviceGroup;
        this.serviceNomenklature = serviceNomenklature;
    }

    public ServiceType(String filePath, String fileHash, String name, Set<AuxiliaryField> auxiliaryFields, ServiceGroup serviceGroup, String serviceNomenklature) {
        super(filePath, fileHash);
        this.name = name;
        this.auxiliaryFields = auxiliaryFields;
        this.serviceGroup = serviceGroup;
        this.serviceNomenklature = serviceNomenklature;
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

    public Set<AuxiliaryField> getAuxiliaryFields() {
        return auxiliaryFields;
    }

    public void setAuxiliaryFields(Set<AuxiliaryField> auxiliaryFields) {
        this.auxiliaryFields = auxiliaryFields;
    }

    public ServiceGroup getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(ServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    public String getServiceNomenklature() {
        return serviceNomenklature;
    }

    public void setServiceNomenklature(String serviceNomenklature) {
        this.serviceNomenklature = serviceNomenklature;
    }


}
