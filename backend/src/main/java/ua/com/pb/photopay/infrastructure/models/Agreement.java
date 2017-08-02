package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Response app agreement
 */
@Entity
@Table(name = "agreement")
public class Agreement {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Agreement branch
     */
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    /**
     * Pd agreements for current agreement type
     */
    @OneToMany(targetEntity = PdAgreement.class, mappedBy = "agr", fetch = FetchType.LAZY)
    private Set<PdAgreement> pdAgreements;


    public Agreement() {
    }

    public Agreement(Branch branch, ServiceType serviceType, Set<PdAgreement> pdAgreements) {
        this.branch = branch;
        this.serviceType = serviceType;
        this.pdAgreements = pdAgreements;
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

    public Set<PdAgreement> getPdAgreements() {
        return pdAgreements;
    }

    public void setPdAgreements(Set<PdAgreement> pdAgreements) {
        this.pdAgreements = pdAgreements;
    }
}
