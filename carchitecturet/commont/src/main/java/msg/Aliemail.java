package msg;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lessismore.commont.util.PropertyUtil;


public class Aliemail {
	private static Aliemail aliemail = new Aliemail();
	private Aliemail() {}
	private static String accessKeyId;
    private static String accessKeySecret;
	public static Aliemail getInstance(){
		return aliemail;
	}
	static {
		//从配置文件读取属性
		accessKeyId = PropertyUtil.getProperty("ali.access_key");
    	accessKeySecret = PropertyUtil.getProperty("ali.access_secret");
	}
	
	/**
	 * 发送邮件
	 * @param emailAddress 邮件地址
	 * @return 验证码
	 */
	public String sendEmail(String emailAddress) {        
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
         //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
//            request.setAccountName("lessismore@www.lessismore520.com");
//            request.setFromAlias("少即多有限公司");
        	request.setAccountName(PropertyUtil.getProperty("ali.email.accountName"));
            request.setFromAlias(PropertyUtil.getProperty("ali.email.fromAlias"));
            request.setAddressType(1);
            request.setTagName("验证码");
            request.setReplyToAddress(true);
            request.setToAddress(emailAddress);
            request.setSubject("验证邮箱");
            int code = (int) ((Math.random()*9+1)*100000);
            /*request.setHtmlBody("<div><p>尊敬的用户:</p><p>&nbsp; &nbsp; &nbsp; <span style='color:#595959'>&nbsp;<strong style='font-size:24px;white-space:normal'><span style='color:#595959'>您好！</span></strong></span><span style='font-size:24px'><strong><span style='color:#595959'>您的验证码为："+code+"</span></strong><span style='color:#595959'>，<strong>15分钟有效，请及时输入</strong></span></span></p><p><span style='font-size:24px'><span style='color:#595959'><strong><br></strong></span></span></p><p><span style='white-space:normal'>"+PropertyUtil.getProperty("ali.email.accountName")+"</span></p></div>");*/
            request.setHtmlBody("<div><p>尊敬的用户:</p><p>&nbsp; &nbsp; &nbsp; <span style='color:#595959'>&nbsp;<strong style='font-size:24px;white-space:normal'><span style='color:#595959'>您好！</span></strong></span><span style='font-size:24px'><strong><span style='color:#595959'>给您推送的接口为："+code+"</span></strong><span style='color:#595959'>，<strong>接口测试成功</strong></span></span></p><p><span style='font-size:24px'><span style='color:#595959'><strong><br></strong></span></span></p><p><span style='white-space:normal'>"+PropertyUtil.getProperty("ali.email.accountName")+"</span></p></div>");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            return Integer.toString(code);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
		return null;
    }
	
	public static void main(String[] args) {
		Aliemail.getInstance().sendEmail("1305993407@qq.com");		
	}
}
