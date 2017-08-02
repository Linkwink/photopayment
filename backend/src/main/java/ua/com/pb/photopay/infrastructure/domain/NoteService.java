package ua.com.pb.photopay.infrastructure.domain;

import ua.com.pb.photopay.infrastructure.exceptions.EntityNotFoundException;
import ua.com.pb.photopay.infrastructure.models.Note;
import ua.com.pb.photopay.infrastructure.viewmodels.note.NoteAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.note.NoteForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.note.NoteForView;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface NoteService extends BaseService<NoteForSave, NoteAsListItem, NoteForView, Integer> {
    /**
     * Get note by application
     * @param applicationId
     * @return
     * @throws EntityNotFoundException
     */
    Note getNoteByApplication(int applicationId) throws EntityNotFoundException;
}
