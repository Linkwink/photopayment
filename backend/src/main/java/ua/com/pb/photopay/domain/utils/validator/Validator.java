package ua.com.pb.photopay.domain.utils.validator;

import ua.com.pb.photopay.infrastructure.constants.Constants.FieldsConstraints;
import ua.com.pb.photopay.infrastructure.models.AuxiliaryField;
import ua.com.pb.photopay.infrastructure.models.ServiceGroup;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class Validator {

    public static boolean isValid(ServiceGroup serviceGroup) {
        int nameLength = serviceGroup.getName().length();
        return nameLength >= FieldsConstraints.ServiceGroup.NAME_MIN_LENGTH && nameLength <= FieldsConstraints.ServiceGroup.NAME_MAX_LENGTH;
    }

    public static boolean isValid(AuxiliaryField auxiliaryField) {
        int nameLength = auxiliaryField.getName().length();
        return nameLength >= FieldsConstraints.AuxiliaryField.NAME_MIN_LENGTH && nameLength <= FieldsConstraints.AuxiliaryField.NAME_MAX_LENGTH;
    }

}
