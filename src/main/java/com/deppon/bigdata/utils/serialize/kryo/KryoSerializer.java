package com.deppon.bigdata.utils.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.utils.serialize.kryo
 * <p>
 * Description:
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/20
 */
public class KryoSerializer {

    private Kryo kryo = new Kryo();


    public <T> byte[] serialize(T object) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Output output = new Output(outputStream);
            kryo.writeObject(output, object);
            output.flush();
            bytes = outputStream.toByteArray();
            outputStream.close();
            output.close();
            return bytes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            Input input = new Input(byteArrayInputStream);
            Object object = kryo.readObject(input, clazz);
            byteArrayInputStream.close();
            input.close();
            return (T)object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
