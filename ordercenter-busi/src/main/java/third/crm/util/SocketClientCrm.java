package third.crm.util;


import com.alibaba.fastjson.JSONObject;
import com.drpeng.ordercenter.persistence.entity.OrdOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
public class SocketClientCrm
{
	private static final Logger log = LoggerFactory.getLogger(SocketClientCrm.class);


	public  static Map<String, Object> excCommand(OrdOrder ordOrder, Map<String, Object> busiParamsVO, String strComd) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
        //获取公共参数
		Map<String,String> pubInfoMap = buildPubInfoMap(ordOrder);
        //获取最终报文
        String strJson = buildFullRequest(busiParamsVO, strComd, pubInfoMap);
		log.info("---入参strJson---"+strJson);
		String strJsonData = null;
		try{
 			strJsonData = SocketClient.send("WEB", strJson);
        }catch (Exception e){
			log.error("调用接口出错"+e.getMessage());
			throw new Exception(e.getMessage());
		}
		//解析返回报文
		log.info("strComd-----"+strComd+"---TransactionId---"+pubInfoMap.get("TransactionId")+"返回json:" + strJsonData);
        JSONObject jsonData = (JSONObject) JSONObject.parse(strJsonData);
        JSONObject jsonResponse = (JSONObject) jsonData.get("Response");
        JSONObject jsonErrorInfo = (JSONObject) jsonResponse.get("ErrorInfo");
        JSONObject jsonRetInfo = (JSONObject) jsonResponse.get("RetInfo");
        map.put("ErrorInfo", jsonErrorInfo.toJSONString());
        map.put("RetInfo", jsonRetInfo.toJSONString());
        return map;
	}

    /**
     * 转换为最后发送请求的json报文
     * @param busiParamsVO
     * @param strComd
     * @param pubInfoMap
     * @return
     */
    private static String buildFullRequest(Map<String, Object> busiParamsVO, String strComd, Map<String, String> pubInfoMap) {
        JSONObject fullMsg = new JSONObject();
        JSONObject requestObj = new JSONObject();
        requestObj.put("BusiParams",busiParamsVO);
        requestObj.put("BusiCode",strComd);
        fullMsg.put("Request",requestObj);
        fullMsg.put("PubInfo",pubInfoMap);
        return fullMsg.toJSONString();
    }


    private static Map<String,String> buildPubInfoMap(OrdOrder ordOrder) throws Exception {
		if(ordOrder == null){
	        log.error("invorkOperator不能为空");
	        throw new Exception("invorkOperator不能为空");
	    }
		Map<String,String> pubInfoMap = new HashMap<String, String>();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String transactionTime = format.format(date);


		pubInfoMap.put("TransactionId", "ORDERCENTER"+transactionTime+getSixRandNumber());
		pubInfoMap.put("TransactionTime", transactionTime);
		pubInfoMap.put("InterfaceId", "");
		pubInfoMap.put("InterfaceType", "4");
		pubInfoMap.put("OpId", String.valueOf(ordOrder.getOperatorId()));
		//TODO pubInfoMap.put("CountyCode", String.valueOf(ordOrder.get));
		pubInfoMap.put("OrgId", String.valueOf(ordOrder.getOrganizationId()));
		pubInfoMap.put("RegionCode", String.valueOf(ordOrder.getCityId()));
		pubInfoMap.put("ClientIP", "");
		return pubInfoMap;
	}
    private static String getSixRandNumber()
    {
        long time = new Date().getTime();
        Random ran = new Random(time);
        int nRand = (ran.nextInt() % 876543) + 123457;
        nRand = Math.abs(nRand);
        String sRand = String.valueOf(nRand);
        int len = 6 - sRand.length();
        if (len > 0)
        {
            for (int i = 0; i < len; i++)
            {
                sRand = "0" + sRand;
            }
        }
        else if (len > 0)
        {
            sRand = String.valueOf(nRand % 1000000);
        }
        return sRand;
    }


    public static void main(String[] args) {
        Map<String,String> pubInfo = new HashMap<String,String>();
        Map<String,Object> busiParamsVO = new HashMap<String,Object>();

        pubInfo.put("InterfaceId","");
        pubInfo.put("TransactionId","WEB20150210145501691942");
        pubInfo.put("InterfaceType","35");
        pubInfo.put("OpId","8128");
        pubInfo.put("OrgId","30000062");
        pubInfo.put("ClientIP","");
        pubInfo.put("RegionCode","");
        pubInfo.put("TransactionTime","20150210145501");
        busiParamsVO.put("ServiceNum","010010079130");

    }
}
