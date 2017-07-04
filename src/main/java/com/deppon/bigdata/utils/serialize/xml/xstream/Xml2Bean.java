package com.deppon.bigdata.utils.serialize.xml.xstream;

import com.deppon.bigdata.entity.SimpleDateConverter;
import com.deppon.bigdata.entity.User;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.util.Date;
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
public class Xml2Bean {

    public static void xml2Bean(){
        try {
            XStream xStream = new XStream();
            xStream.alias("userMap", Map.class);
            xStream.alias("userInfo", Map.Entry.class);
            xStream.processAnnotations(User.class);
			xStream.registerLocalConverter(Date.class, "birthDate", new SimpleDateConverter());
            xStream.autodetectAnnotations(true);  //设置Annotiation

            Map<String, User> map = (Map<String, User>) xStream.fromXML(new File("D:\\serialize\\mapXml.xml"));
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String args[]){
        xml2Bean();
    }

}
