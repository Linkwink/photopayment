package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.ChatMassageService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.ChatMassage;
import ua.com.pb.photopay.infrastructure.viewmodels.chatMassage.ChatMassageAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.chatMassage.ChatMassageForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.chatMassage.ChatMassageForView;

import java.util.List;
import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class ChatMassageServiceImp implements ChatMassageService {
    @Override
    public Set<ChatMassage> getMessagesByChat(int chatId) {
        return null;
    }

    @Override
    public ChatMassageForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<ChatMassageAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(ChatMassageForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
