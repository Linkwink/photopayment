package ua.com.pb.photopay.domain.utils.hashizer;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * Created by dn110592kvo on 09.08.2017.
 */
public class HashGenerator {
    public static String getHash(String string) {
        return DigestUtils.md5Hex(new Date().getTime() + string);
    }
}
