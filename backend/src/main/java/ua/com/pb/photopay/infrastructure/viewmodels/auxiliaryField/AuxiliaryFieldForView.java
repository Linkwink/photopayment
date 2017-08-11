package ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForView;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class AuxiliaryFieldForView implements ViewModelForView, ViewModelAsListItem {
    private int id;
    private String name;
    private BaseModelForView type;

    public AuxiliaryFieldForView() {
    }

    public AuxiliaryFieldForView(int id, String name, BaseModelForView type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public BaseModelForView getType() {
        return type;
    }

    public void setType(BaseModelForView type) {
        this.type = type;
    }
}
