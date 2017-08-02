package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.ChatService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Chat;
import ua.com.pb.photopay.infrastructure.viewmodels.chat.ChatAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.chat.ChatForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.chat.ChatForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class ChatServiceImp implements ChatService {

    @Override
    public Chat findByApplication(int applicationId) throws EntityNotFoundException {
        return null;
    }

    @Override
    public ChatForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<ChatAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(ChatForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
