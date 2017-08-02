package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents chat for application
 */
@Entity
@Table(name = "chat")
public class Chat {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(targetEntity = ChatMassage.class, mappedBy = "chat", fetch = FetchType.EAGER)
    private Set<ChatMassage> massages;

    @OneToOne(optional = false, mappedBy = "applicationChat")
    private Application application;

    public Chat() {
    }

    public Chat(Set<ChatMassage> massages, Application application) {
        this.massages = massages;
        this.application = application;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Set<ChatMassage> getMassages() {
        return massages;
    }

    public void setMassages(Set<ChatMassage> massages) {
        this.massages = massages;
    }
}
