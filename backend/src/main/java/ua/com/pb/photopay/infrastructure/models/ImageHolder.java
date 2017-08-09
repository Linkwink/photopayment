package ua.com.pb.photopay.infrastructure.models;

import javax.persistence.MappedSuperclass;

/**
 * Created by dn110592kvo on 09.08.2017.
 * Class represents default fields for saving file data
 */
@MappedSuperclass
public abstract class ImageHolder {

    private String filePath;
    private String fileHash;

    public String getFilePath() {
        return filePath;
    }

    public ImageHolder() {
    }

    public ImageHolder(String filePath, String fileHash) {
        this.filePath = filePath;
        this.fileHash = fileHash;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }
}
