package com.deppon.bigdata.utils.serialize.jdk;

import java.io.*;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.utils.serialize.jdk
 * <p>
 * Description:
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/20
 */
public class JdkSerializer {

    public <T> byte[] serialize(T object) {
        byte[] bytes = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(object);
            bytes = out.toByteArray();
            //写完后关闭流
            objectOutputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream ;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = null;
            try {
                object = objectInputStream.readObject();
                //关闭流
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return (T) object;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
