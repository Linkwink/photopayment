package ua.com.pb.photopay.domain.utils.normalizer;

/**
 * Created by dn110592kvo on 06.07.2017.
 */
public class NameNormalizer {

    public static String normalize(String name) {
        return name.trim();
    }

    public static String normalize(String name, NormalizationType type) {
        name = normalize(name);
        switch (type) {
            case TO_LOWER:
                name = name.toLowerCase();
                break;
            case TO_UPPER:
                name = name.toUpperCase();
                break;
        }
        return normalize(name);
    }

    public enum NormalizationType {
        TO_LOWER, TO_UPPER
    }

}
