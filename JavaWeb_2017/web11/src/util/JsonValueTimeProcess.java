package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * ʱ��ת����   ʵ��JsonValueTimeProcess�ӿ��е���������
 * ajax�е�ʱ��ת��
 * ����ָ����ʽ��ʱ�����ת��
 */
public class JsonValueTimeProcess implements JsonValueProcessor{
	private String pattern = "yyyy/MM/dd hh:mm:ss";
	
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Object obj = sdf.format((Date)arg0);
		return obj;
	}

	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Object obj = sdf.format((Date)arg1);
		return obj;
	}

}
