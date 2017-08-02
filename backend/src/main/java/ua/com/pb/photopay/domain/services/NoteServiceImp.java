package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import ua.com.pb.photopay.infrastructure.domain.NoteService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Note;
import ua.com.pb.photopay.infrastructure.viewmodels.note.NoteAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.note.NoteForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.note.NoteForView;

import java.util.List;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class NoteServiceImp implements NoteService {

    @Override
    public Note getNoteByApplication(int applicationId) throws EntityNotFoundException {
        return null;
    }

    @Override
    public NoteForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<NoteAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(NoteForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
