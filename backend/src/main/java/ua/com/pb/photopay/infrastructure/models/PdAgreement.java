package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by dn110592kvo on 03.07.2017.
 * Represents privatdogovor agr
 */
@Entity
@Table(name = "pd_agreement")
public class PdAgreement {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Agreement agr;

    /**
     * OKPO of agr
     */
    private long okpo;

    /**
     * CtypeId of agr
     */
    private long ctypeId;
    /**
     * Agreement id
     */
    private long agreementUnique;
    /**
     * Agreement number
     */
    private long agreementNumber;
    /**
     * Date of agr
     */
    private LocalDateTime agreementDate;
    /**
     * First checking account
     */
    private long checkingAccountFirst;
    /**
     * Second checking acoount
     */
    private long checkingAccountSecond;

    public PdAgreement() {
    }

    public PdAgreement(Agreement agr, long okpo, long ctypeId, long agreementUnique, long agreementNumber, LocalDateTime agreementDate, long checkingAccountFirst, long checkingAccountSecond) {
        this.agr = agr;
        this.okpo = okpo;
        this.ctypeId = ctypeId;
        this.agreementUnique = agreementUnique;
        this.agreementNumber = agreementNumber;
        this.agreementDate = agreementDate;
        this.checkingAccountFirst = checkingAccountFirst;
        this.checkingAccountSecond = checkingAccountSecond;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agreement getAgr() {
        return agr;
    }

    public void setAgr(Agreement agr) {
        this.agr = agr;
    }

    public long getOkpo() {
        return okpo;
    }

    public void setOkpo(long okpo) {
        this.okpo = okpo;
    }

    public long getCtypeId() {
        return ctypeId;
    }

    public void setCtypeId(long ctypeId) {
        this.ctypeId = ctypeId;
    }

    public long getAgreementUnique() {
        return agreementUnique;
    }

    public void setAgreementUnique(long agreementUnique) {
        this.agreementUnique = agreementUnique;
    }

    public long getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(long agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public LocalDateTime getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(LocalDateTime agreementDate) {
        this.agreementDate = agreementDate;
    }

    public long getCheckingAccountFirst() {
        return checkingAccountFirst;
    }

    public void setCheckingAccountFirst(long checkingAccountFirst) {
        this.checkingAccountFirst = checkingAccountFirst;
    }

    public long getCheckingAccountSecond() {
        return checkingAccountSecond;
    }

    public void setCheckingAccountSecond(long checkingAccountSecond) {
        this.checkingAccountSecond = checkingAccountSecond;
    }
}
