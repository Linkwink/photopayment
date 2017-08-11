package ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForSave;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class AuxiliaryFieldForSave implements ViewModelForSave {
    private int id;
    private String name;
    private int fieldTypeId;

    public AuxiliaryFieldForSave() {
    }

    public AuxiliaryFieldForSave(int id, String name, int fieldTypeId) {
        this.id = id;
        this.name = name;
        this.fieldTypeId = fieldTypeId;
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

    public int getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(int fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }
}
