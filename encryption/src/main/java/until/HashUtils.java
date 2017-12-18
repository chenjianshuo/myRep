package until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by chenjianshuo on 2017/11/1 17:28.
 */
public class HashUtils {
    private HashUtils() {
    }

    private static final Logger logger = LoggerFactory.getLogger(HashUtils.class);

    /**
     * sha1
     * @param text
     * @return
     */
    public static final String sha1(String text) {
        Formatter ft = new Formatter();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(text.getBytes(StandardCharsets.UTF_8));
            for (byte b : md.digest()) {
                ft.format("%02x", b);
            }
            return ft.toString();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            ft.close();
        }

        return null;
    }

    /**
     * md5
     * @param text
     * @return
     */
    public static final String md5(String text) {
        MessageDigest md = null;
        StringBuilder sb = new StringBuilder();

        try {
            md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes(StandardCharsets.UTF_8));
            for (byte b : md.digest()) {
                int n = b;
                if (n < 0) n += 256;
                if (n < 16) sb.append("0");
                sb.append(Integer.toHexString(n));
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }

        return sb.toString();
    }

    /**
     * TODO:未完成，先对数据进行SHA1 再进行MD5
     *  @param  originalString
     */
    public static String MD5_Hash(String originalString)
    {
        // String APIKey = ConfigurationManager.AppSettings["APIKey"];
       /* SHA1 sha1 = new SHA1CryptoServiceProvider();
        byte[] bytes_sha1_in = Utf8.encode(APIKey + originalString.toLowerCase());
        byte[] bytes_sha1_out = sha1.ComputeHash(bytes_sha1_in);
        string str_sha1_out = BitConverter.ToString(bytes_sha1_out);*/

        //String str_sha1_out = until.HashUtils.sha1(APIKey + originalString.toLowerCase());

        /*MD5 md5 = new MD5CryptoServiceProvider();
        byte[] bytes_md5_in = UTF8Encoding.Default.GetBytes(str_sha1_out + APIKey);
        byte[] bytes_md5_out = md5.ComputeHash(bytes_md5_in);
        string str_md5_out = BitConverter.ToString(bytes_md5_out);*/
        //String str_md5_out = until.HashUtils.md5(str_sha1_out + APIKey);
        //return str_md5_out;
        return null;
    }

    // 团贷网密码加密算法
    public static String md5Passwrod(String password) {
        // 加密码
        StringBuffer str = new StringBuffer();
        str.append("tuan").append(password).append("dai");
        String results = null;
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(str.toString().getBytes());
            String sha1_input = byteToStringHex(result);// sb.toString().toUpperCase();
            mDigest = MessageDigest.getInstance("MD5");
            String md5input = sha1_input.toUpperCase();
            mDigest.update(md5input.getBytes());
            result = mDigest.digest();
            results = byteToStringHex(result);// buf.toString();
        } catch (NoSuchAlgorithmException e) {
            //
        }

        return results;
    }

    public static String byteToStringHex(byte[] result) {
        StringBuffer sb = new StringBuffer();
        for (byte element : result) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * sha1和Md5加密
     * @param jsonString
     * @param thirdKey
     * @return
     */
    public static String sha1AndMd5(String jsonString,String thirdKey){
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
            String inputKey=thirdKey+jsonString.toLowerCase();
            byte[] result = mDigest.digest(inputKey.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
                if(i<result.length-1){
                    sb.append("-");
                }
            }
            String sha1Input=sb.toString().toUpperCase();
            mDigest = MessageDigest.getInstance("MD5");
            String md5input=sha1Input.toUpperCase()+thirdKey;
            mDigest.update(md5input.getBytes());
            result = mDigest.digest();
            StringBuffer buf = new StringBuffer("");
            for (int i = 0; i < result.length; i++) {
                buf.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
                if(i<result.length-1){
                    buf.append("-");
                }
            }
            return buf.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            logger.error("SHA1和MD5加密出错", e);
        }
        return null;
    }
}
