package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents type of service
 */
@Entity
@Table(name = "service_type")
public class ServiceType {
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

    @OneToMany(mappedBy = "serviceType", fetch = FetchType.EAGER, targetEntity = AuxiliaryField.class)
    private Set<AuxiliaryField> auxiliaryFields;

    @ManyToOne
    private ServiceGroup serviceGroup;

    /**
     * Service type id (trash service - 1226 ... )
     */
    private int serviceId;

    public ServiceType() {
    }

    public ServiceType(String name, Set<AuxiliaryField> auxiliaryFields, int serviceId) {
        this.name = name;
        this.auxiliaryFields = auxiliaryFields;
        this.serviceId = serviceId;
    }

    public ServiceType(String name, Set<AuxiliaryField> auxiliaryFields, ServiceGroup serviceGroup, int serviceId) {
        this.name = name;
        this.auxiliaryFields = auxiliaryFields;
        this.serviceGroup = serviceGroup;
        this.serviceId = serviceId;
    }

    public ServiceGroup getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(ServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;
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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Set<AuxiliaryField> getAuxiliaryFields() {
        return auxiliaryFields;
    }

    public void setAuxiliaryFields(Set<AuxiliaryField> auxiliaryFields) {
        this.auxiliaryFields = auxiliaryFields;
    }
}
