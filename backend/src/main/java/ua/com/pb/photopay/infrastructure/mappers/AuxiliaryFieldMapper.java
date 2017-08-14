package ua.com.pb.photopay.infrastructure.mappers;

import ua.com.pb.photopay.infrastructure.models.AuxiliaryField;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;

/**
 * Created by dn110592kvo on 11.08.2017.
 */
public class AuxiliaryFieldMapper {


    public static AuxiliaryFieldForView mapView(AuxiliaryField auxiliaryField) {
        return new AuxiliaryFieldForView(auxiliaryField.getId(), auxiliaryField.getName(), BaseModelMapper.map(auxiliaryField.getFieldType()));
    }

}
