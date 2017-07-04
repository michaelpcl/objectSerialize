package com.deppon.bigdata.utils.serialize.json.jack_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.utils.serialize.json.jack_json
 * <p>
 * Description:
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/21
 */
public class JackJSONSerializer {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> byte[] serialize(T object) {
        try {
            return mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try {
            return mapper.readValue(bytes, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
