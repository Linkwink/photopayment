package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Describes user attachemnts
 */
@Entity
@Table(name = "attachment")
public class Attachment {
    /**
     * Unque id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Application thats attachments belongs
     */
    @ManyToOne(targetEntity = Application.class)
    private Application application;

    /**
     * attachment fileName
     */
    private String fileName;

    /**
     * Path to file on server
     */
    private String filePath;

    /**
     * PrivatBank SHP ticket
     */
    private Long shpTicket;

    public Attachment() {
    }

    public Attachment(Application application, String fileName, String filePath, Long shpTicket) {
        this.application = application;
        this.fileName = fileName;
        this.filePath = filePath;
        this.shpTicket = shpTicket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getShpTicket() {
        return shpTicket;
    }

    public void setShpTicket(Long shpTicket) {
        this.shpTicket = shpTicket;
    }
}
