package main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dto.AssetSideRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import until.CommonUtils;
import until.DESUtils;
import until.HashUtils;

/**
 * Created by chenjianshuo on 2017/11/1 17:13.
 */
public class EncodeParamService {
   private static Logger logger= LoggerFactory.getLogger(EncodeParamService.class);

    public static String encodeParam(String tdUsername,String key, String parseMap) throws Exception {

        Object object= JSONObject.parseObject(parseMap);
        // 1.明文
        String object2Json = JSON.toJSONString(object);
        logger.info("明文====={}", object2Json);
        // 2.加密
        String enCodeJson = DESUtils.des3EncodeECB1(key, object2Json);
        logger.info("加密====={}", enCodeJson);
        // 3.编码
        String enCodeJson2 = CommonUtils.urlEncode(enCodeJson);
        logger.info("编码====={}", enCodeJson2);
        String serverKey = HashUtils.md5(String.format("Json:%s_tdUserName:%s_Key:%s", enCodeJson2, tdUsername, key));

        AssetSideRequestDTO assetSideRequestDTO = new AssetSideRequestDTO();
        assetSideRequestDTO.setKey(serverKey);
        assetSideRequestDTO.setTdUserName(tdUsername);
        assetSideRequestDTO.setData(enCodeJson2);
        logger.info("密文====={}", JSON.toJSONString(assetSideRequestDTO));
        return JSON.toJSONString(assetSideRequestDTO);
    }

   /* public static void main(String[] args) throws Exception {
        String a=encodeParam("td_chequan","MJNdwerlobvURRJHitgYTEYKopI","{\"fileUrl\":\"http://oatest.bujidele.com:48081/CallBack/FilingZip/?log_id=abe7b605-cbc8-4393-ac93-7a74729c6ead.zip\",\"userId\":\"779EF6C7-594D-4083-A8CF-79C2BFA4D109\",\"uploadType\":2}");
        logger.info(a);
    }*/
}
