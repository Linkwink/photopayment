package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by Viacheslav_Khromoi on 11.08.2017.
 */
@Entity
@Table(name = "application_auxiliary_field")
public class ApplicationAuxiliaryField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private AuxiliaryField auxiliaryField;

    @ManyToOne
    @JoinColumn(name="application_id")
    private Application application;

    private String value;

    public ApplicationAuxiliaryField() {
    }

    public ApplicationAuxiliaryField(AuxiliaryField auxiliaryField, String value) {
        this.auxiliaryField = auxiliaryField;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuxiliaryField getAuxiliaryField() {
        return auxiliaryField;
    }

    public void setAuxiliaryField(AuxiliaryField auxiliaryField) {
        this.auxiliaryField = auxiliaryField;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
