package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;
import ua.com.pb.photopay.infrastructure.models.BaseModel;
import ua.com.pb.photopay.infrastructure.viewmodels.baseModel.BaseModelForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface BaseModelService<T extends BaseModel> {
    List<BaseModelForView> getAll();
    int save(BaseModelForView model) throws InvalidDataException, EntityAlreadyExistsException;
    BaseModelForView getOne(int id);
}
