package com.deppon.bigdata.entity;

import com.thoughtworks.xstream.converters.basic.DateConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.entity
 * <p>
 * Description:
 * @description 做日期转让时通常分为从Bean转XML(这里是Date转String)，和从XML转Bean(从String转Date)
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/20
 */
public class SimpleDateConverter extends DateConverter {

    @Override
    public String toString(Object obj) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");

        return format.format((Date)obj);
    }

    @Override
    public Date fromString(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");

        try {
            return format.parse(str);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return null;
    }
}
