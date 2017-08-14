package ua.com.pb.photopay.api.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.pb.photopay.config.FilePathConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by Viacheslav_Khromoi on 11.08.2017.
 */
@Controller
@RequestMapping("/images/")
public class ImageServeController {

    @Autowired
    private FilePathConfig filePathConfig;


    @RequestMapping(value = "/avatar/{hash}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getAvatar(@PathVariable String hash) throws IOException {
        if (hash != null) {
            Path dir = Paths.get(String.format("%s/%s.PNG", filePathConfig.getResourcesPath(), hash));
            File file = new File(dir.toAbsolutePath().toString());
            return ResponseEntity
                    .ok()
                    .lastModified(file.lastModified())
                    .header("max-age", "84600")
                    .cacheControl(CacheControl.maxAge(30, TimeUnit.HOURS).cachePublic())
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(Files.readAllBytes(file.toPath()));
        }
        return null;
    }

}
