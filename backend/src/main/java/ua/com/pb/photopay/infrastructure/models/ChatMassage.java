package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by dn110592kvo on 03.07.2017.
 */
@Entity
@Table(name = "chat_massage")
public class ChatMassage {
    /**
     * Unique id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User autor;

    @ManyToOne
    private Chat chat;

    private String massage;

    public ChatMassage() {
    }

    public ChatMassage(User autor, Chat chat, String massage) {
        this.autor = autor;
        this.chat = chat;
        this.massage = massage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
