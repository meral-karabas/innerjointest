package com.ts.innerjointest.it;

import com.ts.innerjointest.response.InnerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class InnerJoinControllerIntegrationTest {

    @LocalServerPort
    private    Integer  portNumber;

    @Autowired
    TestRestTemplate    testRestTemplate;

    @Test
    public void getTest(){

        ResponseEntity<InnerResponse> responseEntity = testRestTemplate.getForEntity("http://localhost:" + portNumber + "/get", InnerResponse.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getTb1()).isEqualTo("1");
        assertThat(responseEntity.getBody().getTb2()).isEqualTo("2");
        assertThat(responseEntity.getBody().getTb3()).isEqualTo("3");

    }



}
