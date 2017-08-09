package ua.com.pb.photopay.infrastructure.viewmodels.serviceGroup;

import ua.com.pb.photopay.infrastructure.viewmodels.ViewModelForSave;

/**
 * Created by dn110592kvo on 09.08.2017.
 */
public class ServiceGroupForSave implements ViewModelForSave{

    private int id;
    private String name;


    public ServiceGroupForSave() {
    }

    public ServiceGroupForSave(int id, String name) {
        this.id = id;
        this.name = name;
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
}
