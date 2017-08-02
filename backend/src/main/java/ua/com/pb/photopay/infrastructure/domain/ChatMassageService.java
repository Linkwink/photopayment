package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.models.ChatMassage;
import ua.com.pb.photopay.infrastructure.viewmodels.chatMassage.ChatMassageAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.chatMassage.ChatMassageForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.chatMassage.ChatMassageForView;

import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ChatMassageService extends BaseService<ChatMassageForSave, ChatMassageAsListItem, ChatMassageForView, Integer> {

    /**
     * Get massages by chat
     * @param chatId
     * @return
     */
    Set<ChatMassage> getMessagesByChat(int chatId);
}
