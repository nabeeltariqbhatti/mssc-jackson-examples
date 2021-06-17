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
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1242153125312,\"price\":\"12.99\",\"createdDate\":\"2021-06-17T11:16:56+0500\",\"lastUpdatedDate\":\"2021-06-17T11:16:56.5605498+05:00\",\"myLocalDate\":\"20210617\",\"beerId\":\"edc155a9-ad64-4e3c-9a6c-69e2460ff944\"}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);

    }

}