package ua.com.pb.photopay.infrastructure.viewmodels.baseModel;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class BaseModelForView implements ViewModelAsListItem, ViewModelForView, ViewModelForSave {
    private int id;
    private String name;

    public BaseModelForView() {
    }

    public BaseModelForView(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

