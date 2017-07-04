package com.deppon.bigdata.serialize;

import com.deppon.bigdata.entity.ExternalInfo;
import com.deppon.bigdata.utils.serialize.jdk.JdkSerializer;
import com.deppon.bigdata.utils.serialize.kryo.KryoSerializer;
import com.deppon.bigdata.utils.serialize.protobuffer.ProtoBufferSerializer;
import org.junit.Test;

/**
 * Created by yingren on 2016/12/2.
 */
public class ExternalSerializeTest {

    @Test
    public void externalTest() {
        ExternalInfo externalInfo = new ExternalInfo();
        externalInfo.setId(1);
        externalInfo.setPassword("xxxxx");
        externalInfo.setUsername("小明");

        //jdk
        JdkSerializer jdkSerializer = new JdkSerializer();
        byte[] serialize = jdkSerializer.serialize(externalInfo);
        ExternalInfo deExternalInfo = jdkSerializer.deserialize(serialize, ExternalInfo.class);
        //Assert.assertEquals(externalInfo.getId(), deExternalInfo.getId());
        //Assert.assertEquals(externalInfo.getPassword(), deExternalInfo.getPassword());
        //Assert.assertEquals(externalInfo.getUsername()+"用户", deExternalInfo.getUsername());
        System.out.println("**************jdk");
        System.out.println(deExternalInfo.getId());
        System.out.println(deExternalInfo.getPassword());
        System.out.println(deExternalInfo.getUsername());

        //protobuffer
        ProtoBufferSerializer protoBufferSerializer = new ProtoBufferSerializer();
        serialize = protoBufferSerializer.serialize(externalInfo);
        deExternalInfo = protoBufferSerializer.deserialize(serialize, ExternalInfo.class);
        //Assert.assertEquals(externalInfo.getId(), deExternalInfo.getId());
        //Assert.assertEquals(externalInfo.getPassword(), deExternalInfo.getPassword());
        //Assert.assertEquals(externalInfo.getUsername(), deExternalInfo.getUsername());
        System.out.println("**************protobuffer");
        System.out.println(deExternalInfo.getId());
        System.out.println(deExternalInfo.getPassword());
        System.out.println(deExternalInfo.getUsername());

        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] serializeKryo = kryoSerializer.serialize(externalInfo);
        deExternalInfo = kryoSerializer.deserialize(serializeKryo,ExternalInfo.class);
        System.out.println("**************kryo");
        System.out.println(deExternalInfo.getId());
        System.out.println(deExternalInfo.getPassword());
        System.out.println(deExternalInfo.getUsername());
    }

}
