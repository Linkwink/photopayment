package ua.com.pb.photopay.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.domain.AttachmentService;
import ua.com.pb.photopay.infrastructure.exceptions.*;
import ua.com.pb.photopay.infrastructure.models.Attachment;
import ua.com.pb.photopay.infrastructure.viewmodels.attachment.AttachmentAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.attachment.AttachmentForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.attachment.AttachmentForView;

import java.util.List;
import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
@Service
public class AttachmentServiceImp implements AttachmentService {


    @Override
    public int save(int applicationId, MultipartFile file) {
        return 0;
    }

    @Override
    public Set<Attachment> getAllByApplication(int applicationId) {
        return null;
    }

    @Override
    public AttachmentForView find(Integer integer) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<AttachmentAsListItem> findAll() {
        return null;
    }

    @Override
    public Integer save(AttachmentForSave newEntity) throws EntityAlreadyExistsException, CanNotCreateEntityException, InvalidDataException, UsesForbiddenChannelException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
