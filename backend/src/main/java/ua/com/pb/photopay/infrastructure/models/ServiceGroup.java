package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 08.08.2017.
 */

@Entity
@Table(name = "service_group")
public class ServiceGroup extends ImageHolder implements BaseModel {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Service type name
     */
    @Column(nullable = false)
    private String name;

    public ServiceGroup() {
    }

    public ServiceGroup(String name) {
        this.name = name;
    }

    public ServiceGroup(String filePath, String fileHash, String name) {
        super(filePath, fileHash);
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
