package ua.com.pb.photopay.infrastructure.mappers;

import ua.com.pb.photopay.infrastructure.models.BaseModel;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 * Maps statuses or types to and from base view model
*/
public class BaseModelMapper {

    public static <T extends BaseModel> BaseModelForView map(T status) {
        return ( status != null) ? new BaseModelForView(status.getId(), status.getName()) : null;
    }

    public static <T extends BaseModel> T map(BaseModelForView status, Class<T> tClass) {
        try {
            T t = tClass.newInstance();
            t.setName(status.getName());
            t.setId(status.getId());
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
