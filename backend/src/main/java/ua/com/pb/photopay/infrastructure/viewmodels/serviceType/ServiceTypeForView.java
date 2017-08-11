package ua.com.pb.photopay.infrastructure.viewmodels.serviceType;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForView;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;

import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class ServiceTypeForView implements ViewModelForView, ViewModelAsListItem {

    private int id;
    private String name;
    private Set<AuxiliaryFieldForView> auxiliaryFields;
    private int serviceGroupId;
    private String serviceNomenklature;


    public ServiceTypeForView() {
    }

    public ServiceTypeForView(int id, String name, Set<AuxiliaryFieldForView> auxiliaryFields, int serviceGroupId, String serviceNomenklature) {
        this.id = id;
        this.name = name;
        this.auxiliaryFields = auxiliaryFields;
        this.serviceGroupId = serviceGroupId;
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

    public Set<AuxiliaryFieldForView> getAuxiliaryFields() {
        return auxiliaryFields;
    }

    public void setAuxiliaryFields(Set<AuxiliaryFieldForView> auxiliaryFields) {
        this.auxiliaryFields = auxiliaryFields;
    }

    public int getServiceGroupId() {
        return serviceGroupId;
    }

    public void setServiceGroupId(int serviceGroupId) {
        this.serviceGroupId = serviceGroupId;
    }

    public String getServiceNomenklature() {
        return serviceNomenklature;
    }

    public void setServiceNomenklature(String serviceNomenklature) {
        this.serviceNomenklature = serviceNomenklature;
    }
}
