package com.deppon.bigdata.utils.serialize.xml.xstream;

import com.deppon.bigdata.entity.TestClass;
import com.deppon.bigdata.entity.User;
import com.deppon.bigdata.entity.User2;
import com.thoughtworks.xstream.XStream;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.utils.serialize.xml.xstream
 * <p>
 * Description:
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/20
 */
public class Bean2Xml {

    /**
     *
     * @return
     */
    public static void baseBean2Xml(){
        XStream xStream = new XStream();
        User user = new User(10, "爱怎么", new Date(), 20.223);
        String xml = xStream.toXML(user);//输出到一个string中
        System.out.println(xml);
    }

    /**
     * 实体对象中使用别名
     */
    public static void bean2XML_AnnotionAlias() {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);  //设置Annotiation
        User2 user = new User2(10, "爱怎么", new Date(), 20.223);
        //默认date输出是使用Date的toString()方法，我们提供一个Converter类，重写相关方法可以实现格式化输出
        String xml = xStream.toXML(user);//输出到一个string中
        System.out.println(xml);
    }

    /**
     * 嵌套对象
     */
    public static void bean2XML_mulit() {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);  //设置Annotiation
        xStream.processAnnotations(Class.class);
        xStream.processAnnotations(User.class);
        TestClass clazz = new TestClass();
        clazz.setName("教育技术学201001班");

        User user = new User(10, "D爱怎么", new Date(), 20.223);
        User user2 = new User(102, "D爱怎么2", new Date(), 20.222323);
        User user3 = new User(103, "D爱怎么3", new Date(), 20.222323);
        clazz.getUsers().add(user);
        clazz.getUsers().add(user2);
        clazz.getUsers().add(user3);
        clazz.setNum(clazz.getUsers().size());
        try {
            String xml = xStream.toXML(clazz);//输出到一个string中
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象放入map中
     */
    public static void bean2XML_mulitMap() {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);  //设置Annotiation
        xStream.processAnnotations(Class.class);
        xStream.processAnnotations(User.class);
        Map<String, User> map = new HashMap<String, User>();

        User user = new User(10, "D爱怎么", new Date(), 20.223);
        User user2 = new User(102, "D爱怎么2", new Date(), 20.222323);
        User user3 = new User(103, "D爱怎么3", new Date(), 20.222323);
        map.put(user.getName(), user);
        map.put(user2.getName(), user2);
        map.put(user3.getName(), user3);

        xStream.alias("userMap", Map.class);
        xStream.alias("userInfo", Map.Entry.class);
        try {
            String xml = xStream.toXML(map);//输出到一个string中
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 主函数测试
     * @param args
     */
    public static void main(String args[]){
        System.out.println("baseBean2Xml*********");
        baseBean2Xml();

        System.out.println("bean2XML_AnnotionAlias*********");
        bean2XML_AnnotionAlias();

        System.out.println("bean2XML_mulit*********");
        bean2XML_mulit();

        System.out.println("bean2XML_mulitMap*********");
        bean2XML_mulitMap();
    }

}
