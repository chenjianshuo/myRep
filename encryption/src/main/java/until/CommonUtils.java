package until;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by chenjianshuo on 2017/11/1 17:24.
 */
public class CommonUtils {
    private static final String CHARSET = "UTF-8";
    public static String urlEncode(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, CHARSET);
    }

}
