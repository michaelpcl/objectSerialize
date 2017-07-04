package com.deppon.bigdata.utils.serialize.json.fast_json;

import com.alibaba.fastjson.JSON;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.utils.serialize.json.fast_json
 * <p>
 * Description:
 * fastJson参考地址
 * https://github.com/alibaba/fastjson/wiki/Samples-DataBind
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/21
 */
public class FastJSONSerializer {

    public <T> byte[] serialize(T object) {
        return JSON.toJSONBytes(object);
    }


    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
