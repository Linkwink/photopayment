package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.exceptions.EntityNotFoundException;
import ua.com.pb.photopay.infrastructure.models.Chat;
import ua.com.pb.photopay.infrastructure.viewmodels.chat.ChatAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.chat.ChatForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.chat.ChatForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface ChatService extends BaseService<ChatForSave, ChatAsListItem, ChatForView, Integer> {

    /**
     * Find chat by application
     * @param applicationId
     * @return
     * @throws EntityNotFoundException
     */
    Chat findByApplication(int applicationId) throws EntityNotFoundException;

}
