package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.UsersPojo;

public class APIAdapter {
    //Create payload
    public String createPayload(String name, String id, String job, String createdAT) throws JsonProcessingException {
        UsersPojo usersPojo = new UsersPojo(name, id, job, createdAT);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(usersPojo);

    }


}
