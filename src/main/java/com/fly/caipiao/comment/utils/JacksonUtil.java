package com.fly.caipiao.comment.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class JacksonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	static {
		MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		MAPPER.getSerializationConfig().withDateFormat(df);
	}

	private static final JsonFactory JSONFACTORY = new JsonFactory();

	/**
	 * 转换Java Bean 为 json
	 */
	public static String beanToJson(Object o) {
		StringWriter sw = new StringWriter(300);
		SimpleDateFormat fmt = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		JsonGenerator jsonGenerator = null;
		try {
			jsonGenerator = JSONFACTORY.createJsonGenerator(sw);
			MAPPER.setDateFormat(fmt);
			MAPPER.writeValue(jsonGenerator, o);
			return sw.toString();

		} catch (Exception e) {
			logger.error("beanToJson:", e);
			return null;

		} finally {
			if (jsonGenerator != null) {
				try {
					jsonGenerator.close();
				} catch (Exception e) {
					logger.error("ERROR in beanToJson()...", e);
				}
			}
		}
	}

	/**
	 * json 转 javabean
	 *
	 * @param json
	 * @return
	 */
	public static Object jsonToBean(String json, Class clazz) {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			MAPPER.setDateFormat(fmt);
			return MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			logger.error("jsonToBean:", e);
			return null;
		}
	}

	/**
	 * 转换Java Bean 为 HashMap
	 */
	public static Map<String, Object> beanToMap(Object o) {
		try {
			return MAPPER.readValue(beanToJson(o), HashMap.class);
		} catch (Exception e) {
			logger.error("beanToMap:", e);
			return null;
		}
	}

	/**
	 * 转换Json String 为 HashMap
	 */
	public static Map<String, Object> jsonToMap(String json, boolean collToString) {
		try {
			Map<String, Object> map = MAPPER.readValue(json, HashMap.class);
			if (collToString) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if (entry.getValue() instanceof Collection || entry.getValue() instanceof Map) {
						entry.setValue(beanToJson(entry.getValue()));
					}
				}
			}
			return map;
		} catch (Exception e) {
			logger.error("jsonToMap:", e);
			return null;
		}
	}

	public static class jsonParseException extends Exception {
		public jsonParseException(String message) {
			super(message);
		}
	}

	/**
	 * List<Map> 转换成json
	 *
	 * @param list
	 * @return
	 */
	public static String mapsToJson(List<Map<String, Object>> list) {
		JsonGenerator jsonGenerator = null;
		StringWriter sw = new StringWriter();
		SimpleDateFormat fmt = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			jsonGenerator = JSONFACTORY.createJsonGenerator(sw);
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(fmt);
			mapper.writeValue(jsonGenerator, list);
			jsonGenerator.flush();
			return sw.toString();
		} catch (Exception e) {
			logger.error("mapsToJson:", e);
			return null;
		} finally {
			if (jsonGenerator != null) {
				try {
					jsonGenerator.flush();
					jsonGenerator.close();
				} catch (Exception e) {
					logger.error("mapsToJson:", e);
				}
			}
		}
	}

	/**
	 * json 转List
	 *
	 * @param json
	 * @return
	 */
	public static List<Map<String, String>> jsonToMaps(String json) {
		try {
			if (json != null && !"".equals(json.trim())) {
				JsonParser jsonParse = JSONFACTORY.createJsonParser(new StringReader(json));

				ArrayList<Map<String, String>> arrayList =
                        (ArrayList<Map<String, String>>) new ObjectMapper().readValue(jsonParse, ArrayList.class);
				return arrayList;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("jsonToMaps:", e);
			return null;
		}
	}

	/**
	 * List to json
	 *
	 * @param list
	 * @return
	 */
	public static String listToJson(List list) {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		SimpleDateFormat fmt = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			mapper.setDateFormat(fmt);
			mapper.writeValue(sw, list);
		} catch (Exception e) {
			logger.error("listToJson:", e);
		}
		return sw.toString();
	}

	/**
	 * map 2 json
	 *
	 * @param map
	 * @return
	 *
	 */
	public static String mapToJson(Map<String, String> map){
		StringWriter sw = new StringWriter();
		try{
			MAPPER.writeValue(sw, map);
		}catch(Exception e){
			logger.error("mapToJson:", e);
		}
		return sw.toString();

	}


	public static  String toJson(String key,long value) throws Throwable {
		String json = "{\""+key+"\":"+value+"}";
		return json;
	}

	public static  String toJson(String key,String value)  {
		String json = "{\""+key+"\":"+"["+value+"]"+"}";
		return json;
	}


}
