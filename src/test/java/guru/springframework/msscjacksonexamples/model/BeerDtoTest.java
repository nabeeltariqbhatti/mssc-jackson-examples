package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {


    @Autowired
    ObjectMapper objectMapper;
    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getBeerDto();
        String beerDtoAsString = objectMapper.writeValueAsString(beerDto);
        System.out.println(beerDtoAsString);
    }

    @Test
    void testDeseriliazeDto() throws JsonProcessingException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2021-06-16T14:57:09.3781901+05:00\",\"lastUpdatedDate\":\"2021-06-16T14:57:09.3781901+05:00\",\"myLocalDate\":\"20190603\",\"beerId\":\"8ed4c7eb-ef3a-437e-823e-a26497ed7e71\"}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }

}