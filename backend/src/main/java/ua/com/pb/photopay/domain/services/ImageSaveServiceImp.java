package ua.com.pb.photopay.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.pb.photopay.config.FilePathConfig;
import ua.com.pb.photopay.domain.utils.imageconverter.ImageConverter;
import ua.com.pb.photopay.infrastructure.domain.ImageSaveService;
import ua.com.pb.photopay.infrastructure.exceptions.InvalidDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Viacheslav_Khromoi on 11.08.2017.
 */
@Service
public class ImageSaveServiceImp implements ImageSaveService {

    @Override
    public Path saveImage(MultipartFile file, String pathToSave, boolean makeTransperent, int sizeToResize) throws InvalidDataException {

        Path dir = Paths.get(pathToSave);
        ImageConverter imageConverter = new ImageConverter(sizeToResize);

        try {
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }

            Path path = imageConverter.apply(file.getInputStream());

            if (path != null) {
                path = Files.move(path, dir.resolve(path.getFileName()), REPLACE_EXISTING );
            }
            return path;

        } catch (IOException e) {
            e.printStackTrace();
            throw new InvalidDataException("Image service throw error while saving file", Arrays.asList("file error"));
        }

    }
}
