package cn.edcheung.javaWebBase.fileReader;

/**
 * JSON_Bean FastJson使用
 *
 * @author Edward Cheung
 * 2019/6/22
 */
public class JSON_Bean {
    /*
    FastJson对于json格式字符串的解析主要用到了下面三个类：
    1.JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换
    2.JSONObject：fastJson提供的json对象
    3.JSONArray：fastJson提供json数组对象
    */

    // public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray
    // public static final JSONObject parseObject(String text); // 把JSON文本parse成JSONObject
    // public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean
    // public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
    // public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合
    // public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本
    // public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本
    // public static final Object toJSON(Object javaObject); //将JavaBean转换为JSONObject或者JSONArray。

    // 用户组对象转JSON串
    // String jsonString = JSON.toJSONString(group);

    // JSON串转用户组对象
    // UserGroup group2 = JSON.parseObject(jsonString, UserGroup.class);

    // JSON串转用户对象列表
    // List<User> users2 = JSON.parseArray(jsonString2, User.class);
}
