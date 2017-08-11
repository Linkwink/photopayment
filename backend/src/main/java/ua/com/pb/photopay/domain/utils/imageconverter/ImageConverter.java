package ua.com.pb.photopay.domain.utils.imageconverter;

import ua.com.pb.photopay.domain.utils.hashizer.HashGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
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

    /**
     * Convert image to png, sets img size, set backgound to transperent
     * @param stream
     * @return
     */
    public Path apply(InputStream stream) {
        try {
            double scale;
            Path thumbnailPath = Files.createTempFile(HashGenerator.getHash("temp"), ".PNG").toAbsolutePath();
            BufferedImage imgIn = ImageIO.read(stream);

            int color = imgIn.getRGB(0, 0);

            Image imageWithTransperent = makeColorTransperent(imgIn, new Color(color));

            BufferedImage transperentImage = imageToBufferedImage(imageWithTransperent);

            int imageWidth = transperentImage.getWidth();
            int imageHeight = transperentImage.getHeight();


            if (imageWidth >= imageHeight) {
                // horizontal or square image
                scale = Math.min(maxLongSide, imageWidth) / (double) imageWidth;
            } else {
                // vertical image
                scale = Math.min(maxLongSide, imageHeight) / (double) imageHeight;
            }

            BufferedImage thumbnailOut = new BufferedImage((int) (scale * imageWidth),
                    (int) (scale * imageHeight),
                    transperentImage.getType());
            Graphics2D g = thumbnailOut.createGraphics();

            AffineTransform transform = AffineTransform.getScaleInstance(scale, scale);
            g.drawImage(transperentImage, transform, DUMMY_OBSERVER);
            ImageIO.write(thumbnailOut, "PNG", thumbnailPath.toFile());
            return thumbnailPath;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public Image makeColorTransperent(BufferedImage im, Color color) {
         ImageFilter filter = new RGBImageFilter() {

            public int markerRGB = color.getRGB() | 0xFFFFFFFF;

            @Override
            public int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }


    private BufferedImage imageToBufferedImage(Image image) {
         BufferedImage bufferedImage =
                new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

}
