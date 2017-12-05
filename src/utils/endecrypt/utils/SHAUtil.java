package utils.endecrypt.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/** 
 * 采用SHAA加密
 * @author Xingxing,Xie
 * @datetime 2014-6-1 
 */
public class SHAUtil {
    /*** 
     * SHA加密 生成40位SHA码
     * @param 待加密字符串
     * @return 返回40位SHA码
     * @throws UnsupportedEncodingException 
     */
    public static String shaEncode(String inStr) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray;
		try {
			byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = sha.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) { 
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
    }

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("a123123");
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + shaEncode(str));
    }
}