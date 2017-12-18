package until;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;


/**
 * Created by chenjianshuo on 2017/11/1 17:22.
 */
public class DESUtils {
    private static final String ALGORITHM = "DESede";
    private static final String CHARSET = "UTF-8";
    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    private DESUtils() {
    }

    public static final String des3EncodeECB1(String key, String data) throws Exception {
        DESedeKeySpec spec = new DESedeKeySpec(key.substring(0, 24).getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        Key desKey = keyFactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] bOut = cipher.doFinal(data.getBytes(CHARSET));
        return new String(org.apache.commons.codec.binary.Base64.encodeBase64(bOut));
    }

}
