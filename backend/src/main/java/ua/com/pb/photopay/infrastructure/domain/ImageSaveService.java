package ua.com.pb.photopay.infrastructure.domain;

import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;

import java.nio.file.Path;

/**
 * Created by Viacheslav_Khromoi on 11.08.2017.
 */
public interface ImageSaveService {
    Path saveImage(MultipartFile file, String pathToSave, boolean makeTransperent, int size) throws InvalidDataException;
}

