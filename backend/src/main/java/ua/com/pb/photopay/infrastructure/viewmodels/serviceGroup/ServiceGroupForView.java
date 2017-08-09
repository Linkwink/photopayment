package ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForView;

/**
 * Created by dn110592kvo on 09.08.2017.
 */
public class ServiceGroupForView implements ViewModelForView, ViewModelAsListItem{

    private int id;
    private String name;
    private String avatar;

    public ServiceGroupForView() {
    }

    public ServiceGroupForView(int id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
