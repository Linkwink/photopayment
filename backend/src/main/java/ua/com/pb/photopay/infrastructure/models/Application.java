package ua.com.pb.photopay.infrastructure.models;

import ua.com.pb.photopay.infrastructure.viewmodels.auxiliaryField.AuxiliaryFieldForView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents application that user send to accountant
 */
@Entity
@Table(name = "application")
public class Application {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Application attachments
     */
    @OneToMany(targetEntity = Attachment.class, orphanRemoval = true, mappedBy = "application", fetch = FetchType.EAGER)
    private Set<Attachment> attachments;

    /**
     * Time created
     */
    private LocalDateTime created;

    /**
     * Time of last modifying
     */
    private LocalDateTime lastModified;

    /**
     * User that create this application
     */
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    /**
     * Accountant that processed the application
     */
    @ManyToOne
    @JoinColumn(name = "accountant_id")
    private User accountant;

    /**
     * Time when the accountant took the application to work
     */
    private LocalDateTime accountantStart;

    /**
     * Time when the accountant set application status to "processed"
     */
    private LocalDateTime accountantEnd;

    /**
     * Addiditional info on application
     */
    @OneToMany(targetEntity = AuxiliaryField.class, orphanRemoval = false, mappedBy = "application", fetch = FetchType.EAGER)
    private Set<AuxiliaryField> addiditionalFields;

    /**
     * Agreement of application
     */
    @ManyToOne
    @JoinColumn(name = "agreement_id")
    private Agreement agreement;

    /**
     * Status of application
     */
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private ApplicationStatus applicationStatus;

    /**
     * Chat for current application(for communication from autor to accountant)
     */
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "chat_id")
    private Chat applicationChat;

    /**
     * Application note
     */
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    /**
     * Service type of application
     */
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    /**
     * Id of privatdogovor
     */
    private Long idPrivatDogovor;

    /**
     * Amount of payment
     */
    private float amountOfPayment;

    /**
     * Indicative status
     */
    private boolean indicativeFalse;

    /**
     * Saves application geolocation
     */
    private String geoLocationOnCreate;

    public Application() {
    }

    public Application(Set<Attachment> attachments, LocalDateTime created, LocalDateTime lastModified, User creator, User accountant, LocalDateTime accountantStart, LocalDateTime accountantEnd, Set<AuxiliaryField> addiditionalFields, Agreement agreement, ApplicationStatus applicationStatus, Chat applicationChat, Note note, ServiceType serviceType, Long idPrivatDogovor, float amountOfPayment, boolean indicativeFalse, String geoLocationOnCreate) {
        this.attachments = attachments;
        this.created = created;
        this.lastModified = lastModified;
        this.creator = creator;
        this.accountant = accountant;
        this.accountantStart = accountantStart;
        this.accountantEnd = accountantEnd;
        this.addiditionalFields = addiditionalFields;
        this.agreement = agreement;
        this.applicationStatus = applicationStatus;
        this.applicationChat = applicationChat;
        this.note = note;
        this.serviceType = serviceType;
        this.idPrivatDogovor = idPrivatDogovor;
        this.amountOfPayment = amountOfPayment;
        this.indicativeFalse = indicativeFalse;
        this.geoLocationOnCreate = geoLocationOnCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getAccountant() {
        return accountant;
    }

    public void setAccountant(User accountant) {
        this.accountant = accountant;
    }

    public LocalDateTime getAccountantStart() {
        return accountantStart;
    }

    public void setAccountantStart(LocalDateTime accountantStart) {
        this.accountantStart = accountantStart;
    }

    public LocalDateTime getAccountantEnd() {
        return accountantEnd;
    }

    public void setAccountantEnd(LocalDateTime accountantEnd) {
        this.accountantEnd = accountantEnd;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Chat getApplicationChat() {
        return applicationChat;
    }

    public void setApplicationChat(Chat applicationChat) {
        this.applicationChat = applicationChat;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Long getIdPrivatDogovor() {
        return idPrivatDogovor;
    }

    public void setIdPrivatDogovor(Long idPrivatDogovor) {
        this.idPrivatDogovor = idPrivatDogovor;
    }

    public float getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(float amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public boolean isIndicativeFalse() {
        return indicativeFalse;
    }

    public void setIndicativeFalse(boolean indicativeFalse) {
        this.indicativeFalse = indicativeFalse;
    }

    public String getGeoLocationOnCreate() {
        return geoLocationOnCreate;
    }

    public void setGeoLocationOnCreate(String geoLocationOnCreate) {
        this.geoLocationOnCreate = geoLocationOnCreate;
    }

    public Set<AuxiliaryField> getAddiditionalFields() {
        return addiditionalFields;
    }

    public void setAddiditionalFields(Set<AuxiliaryField> addiditionalFields) {
        this.addiditionalFields = addiditionalFields;
    }
}
