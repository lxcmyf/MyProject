package cn.lxc.vo;

import java.net.URL;

public class Test {
	public static void main(String[] args) {
		 try {
			 User user = new User();
			 Class<? extends User> clazz =  user.getClass();
	            String strClassName = clazz.getName();
	            String strPackageName = "";
	            if (clazz.getPackage() != null) {
	                strPackageName = clazz.getPackage().getName();
	            }
	            String strClassFileName = "";
	            if (!"".equals(strPackageName)) {
	                strClassFileName = strClassName.substring(strPackageName.length() + 1,
	                        strClassName.length());
	            } else {
	                strClassFileName = strClassName;
	            }
	            URL url = null;
	            url = clazz.getResource(strClassFileName + ".class");
	            String strURL = url.toString();
	            strURL = strURL.substring(strURL.indexOf('/') + 1, strURL
	                    .lastIndexOf('/'));
	            //返回当前类的路径，并且处理路径中的空格，因为在路径中出现的空格如果不处理的话，
	            //在访问时就会从空格处断开，那么也就取不到完整的信息了，这个问题在web开发中尤其要注意
	            System.out.println(strURL.replaceAll("%20", "")); 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}
}
