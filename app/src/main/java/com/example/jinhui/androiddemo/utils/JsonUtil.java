package com.example.jinhui.androiddemo.utils;

/**
 * Created by jh on 2018/9/2.
 * Email: 1004260403@qq.com
 * <p>
 * https://www.jianshu.com/p/ec34c7eb0e47
 */
public class JsonUtil {

//    /**
//     * Bean对象转JSON * * @param object * @param dataFormatString * @return
//     */
//    public static String beanToJson(Object object, String dataFormatString) {
//        if (object != null) {
//            if (StringUtils.isEmpty(dataFormatString)) {
//                return JSONObject.toJSONString(object);
//            }
//            return JSON.toJSONStringWithDateFormat(object, dataFormatString);
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * Bean对象转JSON * * @param object * @return
//     */
//    public static String beanToJson(Object object) {
//        if (object != null) {
//            return JSON.toJSONString(object);
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * String转JSON字符串 * * @param key * @param value * @return
//     */
//    public static String stringToJsonByFastjson(String key, String value) {
//        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
//            return null;
//        }
//        Map<String, String> map = new HashMap<String, String>();
//        map.put(key, value);
//        return beanToJson(map, null);
//    }
//
//    /**
//     * 将json字符串转换成对象 * * @param json * @param clazz * @return
//     */
//    public static Object jsonToBean(String json, Object clazz) {
//        if (StringUtils.isEmpty(json) || clazz == null) {
//            return null;
//        }
//        return JSON.parseObject(json, clazz.getClass());
//    }
//
//    /**
//     * json字符串转map * * @param json * @return
//     */
//    @SuppressWarnings("unchecked")
//    public static Map<String, Object> jsonToMap(String json) {
//        if (StringUtils.isEmpty(json)) {
//            return null;
//        }
//        return JSON.parseObject(json, Map.class);
//    }
//
//    /**
//     * 将List集合转换为json字符串 * @param list List集合 * @return
//     */
//    public static <T> String listToJson(List<T> list) {
//        JSONArray jsonArray = new JSONArray();
//        JSONObject jsonObject = null;
//        try {
//            for (int i = 0; i < list.size(); i++) {
//                jsonObject = new JSONObject(objectToJson(list.get(i)));
//                jsonArray.put(jsonObject);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } finally {
//            if (jsonObject != null) {
//                jsonObject = null;
//            }
//        }
//        return jsonArray.toString();
//    }
//
//    /**
//     * 将数组转换成json字符串 * @param array 数组 * @return
//     */
//    public static <T> String arrayToJson(T[] array) {
//        JSONArray jsonArray = new JSONArray();
//        JSONObject jsonObject = null;
//        try {
//            for (int i = 0; i < array.length; i++) {
//                jsonObject = new JSONObject(objectToJson(array[i]));
//                jsonArray.put(jsonObject);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } finally {
//            if (jsonObject != null) {
//                jsonObject = null;
//            }
//        }
//        return jsonArray.toString();
//    }
//
//    /**
//     * 获取json字符串中的值 * @param json json字符串 * @param key 键值 * @param clazz 所取数据类型 * @return 存在则返回正确值，不存在返回null
//     */
//    public static <T> T getJsonObjectValue(String json, String key, Class<T> clazz) {
//        try {
//            return getJsonObjectValue(new JSONObject(json), key, clazz);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 获取jsonObject对象中的值 * @param jsonObject jsonObject对象 * @param key 键值 * @param clazz 所取数据类型，例如：Integer.class，String.class，Double.class，JSONObject.class * @return 存在则返回正确值，不存在返回null
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T getJsonObjectValue(JSONObject jsonObject, String key, Class<T> clazz) {
//        T t = null;
//        try {
//            if (clazz == Integer.class) {
//                t = (T) Integer.valueOf(jsonObject.getInt(key));
//            } else if (clazz == Boolean.class) {
//                t = (T) Boolean.valueOf(jsonObject.getBoolean(key));
//            } else if (clazz == String.class) {
//                t = (T) String.valueOf(jsonObject.getString(key));
//            } else if (clazz == Double.class) {
//                t = (T) Double.valueOf(jsonObject.getDouble(key));
//            } else if (clazz == JSONObject.class) {
//                t = (T) jsonObject.getJSONObject(key);
//            } else if (clazz == JSONArray.class) {
//                t = (T) jsonObject.getJSONArray(key);
//            } else if (clazz == Long.class) {
//                t = (T) Long.valueOf(jsonObject.getLong(key));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return t;
//    }
//
//    /**
//     * json字符串转换为ContentValues * @param json json字符串 * @return
//     */
//    @SuppressWarnings("rawtypes")
//    public static ContentValues jsonToContentValues(String json) {
//        ContentValues contentValues = new ContentValues();
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            Iterator iterator = jsonObject.keys();
//            String key;
//            Object value;
//            while (iterator.hasNext()) {
//                key = iterator.next().toString();
//                value = jsonObject.get(key);
//                String valueString = value.toString();
//                if (value instanceof String) {
//                    contentValues.put(key, valueString);
//                } else if (value instanceof Integer) {
//                    contentValues.put(key, Integer.valueOf(valueString));
//                } else if (value instanceof Long) {
//                    contentValues.put(key, Long.valueOf(valueString));
//                } else if (value instanceof Double) {
//                    contentValues.put(key, Double.valueOf(valueString));
//                } else if (value instanceof Float) {
//                    contentValues.put(key, Float.valueOf(valueString));
//                } else if (value instanceof Boolean) {
//                    contentValues.put(key, Boolean.valueOf(valueString));
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//            throw new Error("Json字符串不合法：" + json);
//        }
//        return contentValues;
//    }



}
