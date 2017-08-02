package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Application notes that users can set
 */
@Entity
@Table(name = "note")
public class Note {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of the note
     */
    @Column(nullable = false)
    private String name;
    /**
     * Text of the note
     */
    @Column(nullable = false)
    private String noteText;

    /**
     * Delivery channel for note
     */
    @ManyToMany
    @JoinTable(name = "node_deliverychannels",
            joinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id", table = "note"),
            inverseJoinColumns = @JoinColumn(name = "deliverychannel_id", referencedColumnName = "id", table = "delivery_channel"))
    private Set<DeliveryChannel> deliveryChannels;



    public Note() {
    }

    public Note(String name, String noteText, Set<DeliveryChannel> deliveryChannels, boolean isEditable) {
        this.name = name;
        this.noteText = noteText;
        this.deliveryChannels = deliveryChannels;
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

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Set<DeliveryChannel> getDeliveryChannels() {
        return deliveryChannels;
    }

    public void setDeliveryChannels(Set<DeliveryChannel> deliveryChannels) {
        this.deliveryChannels = deliveryChannels;
    }

}
