package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents indicative for application
 */
@Entity
@Table(name = "indicative")
public class Indicative {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * For what branch its indicative
     */
    @ManyToOne
    private Branch branch;
    /**
     * Indicative service type
     */
    @ManyToOne
    private ServiceType serviceType;
    /**
     * Indicative amount
     */
    private float indicativeAmount;

    public Indicative() {
    }

    public Indicative(Branch branch, ServiceType serviceType, Long indicativeAmount) {
        this.branch = branch;
        this.serviceType = serviceType;
        this.indicativeAmount = indicativeAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public float getIndicativeAmount() {
        return indicativeAmount;
    }

    public void setIndicativeAmount(float indicativeAmount) {
        this.indicativeAmount = indicativeAmount;
    }
}
