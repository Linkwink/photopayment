package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents delivery channel for notes
 */
@Entity
@Table(name = "delivery_channel")
public class DeliveryChannel implements BaseModel {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of the delivery channel
     */
    @Column(nullable = false)
    private String name;


    public DeliveryChannel() {
    }

    public DeliveryChannel(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
