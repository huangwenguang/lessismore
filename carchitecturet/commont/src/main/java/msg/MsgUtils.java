package msg;

import com.lessismore.commont.util.OKHttpUtil;
import com.lessismore.commont.util.PropertyUtil;

import net.sf.json.JSONObject;



/**
 * 发送普通短信
 * @author lizhihui
 * @since 2017年8月30日
 */
public class MsgUtils {
	private static MsgUtils msgUtils = new MsgUtils();
	private MsgUtils() {}
	private static String user;
	private static String pwd;
	private static String baseUrl = "http://apis.renxinl.com:8080/";
	public static MsgUtils getInstance(){
		return msgUtils;
	}
	/**通用验证码模板*/
	public static final String TEMP_COMMON_ID = "13304";
	/**注册验证码模板*/
	public static final String TEMP_REGESTER_ID = "13301";
	/**登录验证码模板*/
	public static final String TEMP_LOGIN_ID = "13299";
	/**修改手机验证码模板*/
	public static final String TEMP_CHANGE_PHONE_ID = "13298";
	/**查找密码模板*/
	public static final String TEMP_FIND_PASSWORD_ID = "13297";
	/**Qc订单确认模板*/
	public static final String TEMP_QC_ORDER_INSURE = "14553";
	public static final String MSG_SEND_SUCCESS = "0000";
	
	static{
		user = PropertyUtil.getProperty("msg.user");
		pwd = PropertyUtil.getProperty("msg.pwdMd5");
	}
	
	
	public  JSONObject sendMsgCode(String tmpId,String phone){
		//随机生成6位验证码
        int codeNum =(int) ((Math.random()*9+1)*100000);
        String params = phone+","+ codeNum;
		String url = baseUrl+"smsgate/varsend.do?user="+user+"&pwd="+pwd+"&params="+params+"&mid="+tmpId;
		String respond = OKHttpUtil.httpGet(url);
		JSONObject obj = JSONObject.fromObject(respond);
		obj.put("number", codeNum);
		return obj;
	}
	
	public void sendQcOrderMsg(String phone,String qcOrderNum){
		 String params = phone+","+ qcOrderNum;
	     String url = baseUrl+"smsgate/varsend.do?user="+user+"&pwd="+pwd+"&params="+params+"&mid="+TEMP_QC_ORDER_INSURE;
	     String res = OKHttpUtil.httpGet(url);
	     System.out.println(res);
	}
	
	public static void main(String[] args) {
		//MsgUtils.getInstance().sendQcOrderMsg( "13751844549","Test");
		MsgUtils.getInstance().sendMsgCode(TEMP_REGESTER_ID, "15920145706");
	}

}
