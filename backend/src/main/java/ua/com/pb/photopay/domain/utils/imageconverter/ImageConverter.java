package ua.com.pb.photopay.domain.utils.imageconverter;

import ua.com.pb.photopay.domain.utils.hashizer.HashGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by dn110592kvo on 10.08.2017.
 * Uses the built-in JDK tooling for resizing an image.
 */
public class ImageConverter {

    private static final ImageObserver DUMMY_OBSERVER = (img, infoflags, x, y, width, height) -> true;

    private final int maxLongSide;

    public ImageConverter(int maxLongSide) {
        this.maxLongSide = maxLongSide;
    }

    public int getMaxLongSide() {
        return maxLongSide;
    }


    public Path apply(InputStream stream) {
        try {
            Path thumbnailPath = Files.createTempFile(HashGenerator.getHash("temp"), ".PNG").toAbsolutePath();
            BufferedImage imgIn = ImageIO.read(stream);

            double scale;

            if (imgIn.getWidth() >= imgIn.getHeight()) {
                // horizontal or square image
                scale = Math.min(maxLongSide, imgIn.getWidth()) / (double) imgIn.getWidth();
            } else {
                // vertical image
                scale = Math.min(maxLongSide, imgIn.getHeight()) / (double) imgIn.getHeight();
            }

            BufferedImage thumbnailOut = new BufferedImage((int) (scale * imgIn.getWidth()),
                    (int) (scale * imgIn.getHeight()),
                    imgIn.getType());
            Graphics2D g = thumbnailOut.createGraphics();

            AffineTransform transform = AffineTransform.getScaleInstance(scale, scale);
            g.drawImage(imgIn, transform, DUMMY_OBSERVER);
            ImageIO.write(thumbnailOut, "PNG", thumbnailPath.toFile());
            return thumbnailPath;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }


}
