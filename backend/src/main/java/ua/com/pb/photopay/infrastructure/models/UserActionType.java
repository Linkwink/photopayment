package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents user action
 */
@Entity
@Table(name = "user_action_type")
public class UserActionType {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Type's name
     */
    @Column(nullable = false, unique = true)
    private String name;
    /**
     * Logs with such action
     */
    @OneToMany(mappedBy = "userAction", targetEntity = Log.class, fetch = FetchType.EAGER)
    private Set<Log> logs;
    /**
     * Default constructor
     */
    public UserActionType() {
    }
    /**
     * Constructor that initializes type's name
     * @param name
     */
    public UserActionType(String name, String description) {
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

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }
}
