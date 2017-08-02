package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.models.Attachment;
import ua.com.pb.photopay.infrastructure.viewmodels.attachment.AttachmentAsListItem;
import ua.com.pb.photopay.infrastructure.viewmodels.attachment.AttachmentForSave;
import ua.com.pb.photopay.infrastructure.viewmodels.attachment.AttachmentForView;

import java.util.Set;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public interface AttachmentService extends BaseService<AttachmentForSave, AttachmentAsListItem, AttachmentForView, Integer> {

    /**
     * Save attachment
     * @param applicationId
     * @param file
     * @return
     */
    int save(int applicationId, MultipartFile file);

    /**
     * Get all attachments by application
     * @param applicationId
     * @return
     */
    Set<Attachment> getAllByApplication(int applicationId);



}
