package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.models.AuxiliaryField;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface AuxiliaryFieldService extends BaseService<AuxiliaryFieldForSave, AuxiliaryFieldForView, AuxiliaryFieldForView, Integer> {
    boolean isExist(int id);
    AuxiliaryField find(int id);
}
