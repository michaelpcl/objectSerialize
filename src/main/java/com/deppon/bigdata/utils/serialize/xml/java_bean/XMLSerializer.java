package com.deppon.bigdata.utils.serialize.xml.java_bean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.utils.serialize.xml.java_bean
 * <p>
 * Description:
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/21
 *
 * java自带的序列化工具，1.6及以上支持
 */
public class XMLSerializer {

    public <T> byte[] serialize(T object) {
        ByteArrayOutputStream os = null;
        XMLEncoder xe = null;
        try {
            os = new ByteArrayOutputStream();
            xe = new XMLEncoder(os, "UTF-8", true, 0);
            xe.writeObject(object);// 序列化成XML字符串
        } finally {
            if (xe != null) {
                xe.close();
            }
        }
        return os.toByteArray();
    }


    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
             XMLDecoder xd = new XMLDecoder(in)) {
            Object obj = xd.readObject();// 从XML序列中解码为Java对象
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
