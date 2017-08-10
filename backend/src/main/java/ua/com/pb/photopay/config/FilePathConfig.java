package ua.com.pb.photopay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dn110592kvo on 09.08.2017.
 */
@Component
@ConfigurationProperties("application.files.path")
public class FilePathConfig {
    private String root;
    private String user;
    private String resources;

    public FilePathConfig() {
    }

    public FilePathConfig(String root, String user, String resources) {
        this.root = root;
        this.user = user;
        this.resources = resources;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResourcesPath() {
        return String.format("%s/%s", this.root, this.resources);
    }

    public String getUserPath() {
        return String.format("%s/%s", this.root, this.user);
    }
}
