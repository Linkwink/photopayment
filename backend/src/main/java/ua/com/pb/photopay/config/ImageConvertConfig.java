package ua.com.pb.photopay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dn110592kvo on 10.08.2017.
 */
@Component
@ConfigurationProperties("application.images.convert.sizes")
public class ImageConvertConfig {

    private int categoryGroup;

    public ImageConvertConfig() {
    }

    public ImageConvertConfig(int categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public int getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(int categoryGroup) {
        this.categoryGroup = categoryGroup;
    }
}
