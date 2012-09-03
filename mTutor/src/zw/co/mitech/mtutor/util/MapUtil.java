package zw.co.mitech.mtutor.util;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String EQUALS ="==";
	public static final String SEPERATOR ="!!";
	
	public static String convertAttributesMapToString(Map<String,String> attributesMap){
		StringBuffer sb = new StringBuffer();
		for (String key : attributesMap.keySet()) {
			sb.append(key + EQUALS + attributesMap.get(key) + SEPERATOR );
		}
		return sb.toString();
	}
	
	
	public static String convertAttributesMapToString2(Map<String,String> attributesMap){
		StringBuffer sb = new StringBuffer();
		for (String key : attributesMap.keySet()) {
			sb.append(key + EQUALS + attributesMap.get(key) + SEPERATOR );
		}
		return sb.toString();
	}
	
	
	public static Map<String,String> convertAttributesStringToMap(String attributesString){
	
		if(attributesString == null){
			return null;
		}
		Map<String, String> attributesMap = new TreeMap<String, String>();
		int startIndex = 0;
		int endIndex =0;
		endIndex=attributesString.indexOf(EQUALS,startIndex);
		System.out.println("End index::::::"+endIndex);
		System.out.println("start index::::::"+startIndex);
		String key,value;
		while(endIndex >= 0){
			
			key = attributesString.substring(startIndex,endIndex);
			startIndex = endIndex + EQUALS.length();
			endIndex=attributesString.indexOf(SEPERATOR,startIndex);
			value =attributesString.substring(startIndex,endIndex);
			startIndex = endIndex + SEPERATOR.length();
			
			attributesMap.put(key, value);
			endIndex=attributesString.indexOf(EQUALS,startIndex);
		}
		return attributesMap;
	}
	
	public static Map<Long,Long> convertAttributesStringToLongMap(String attributesString){
		
		if(attributesString == null){
			return null;
		}
		Map<Long, Long> attributesMap = new TreeMap<Long, Long>();
		int startIndex = 0;
		int endIndex =0;
		endIndex=attributesString.indexOf(EQUALS,startIndex);
		System.out.println("End index::::::"+endIndex);
		System.out.println("start index::::::"+startIndex);
		String key,value;
		while(endIndex >= 0){
			
			key = attributesString.substring(startIndex,endIndex);
			startIndex = endIndex + EQUALS.length();
			endIndex=attributesString.indexOf(SEPERATOR,startIndex);
			value =attributesString.substring(startIndex,endIndex);
			startIndex = endIndex + SEPERATOR.length();
			
			attributesMap.put(Long.parseLong(key), Long.parseLong(value));
			endIndex=attributesString.indexOf(EQUALS,startIndex);
		}
		return attributesMap;
	}
	
	
	public static void main(String[] args){
		Map<Long, Long> attributesMap = new TreeMap<Long, Long>();
		attributesMap.put(2L, 2L);
		attributesMap.put(4L, 4L);
		String str =convertAttributesLongMapToString(attributesMap);
		convertAttributesStringToMap(str);
		System.out.println("********* string " + str);
		
	}


	public static String convertAttributesLongMapToString(
			Map<Long, Long> attributesMap) {
		StringBuffer sb = new StringBuffer();
		for (Long key : attributesMap.keySet()) {
			sb.append(key + EQUALS + attributesMap.get(key) + SEPERATOR );
		}
		return sb.toString();
	}
	
	

}
