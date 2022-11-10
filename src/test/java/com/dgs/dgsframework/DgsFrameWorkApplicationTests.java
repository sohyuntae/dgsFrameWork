package com.dgs.dgsframework;

import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DgsFrameWorkApplicationTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void step() {
        // WebClientGraphQLClient webClientGraphQLClient = new WebClientGraphQLClient(WebClient.create("http://localhost:" + port + "/graphql"));
    }

    @Test
    public void applicationQueryTest() {

//        //Configure a WebClient for your needs, e.g. including authentication headers and TLS.
//        WebClient webClient = WebClient.create("http://localhost:8080/graphql");
//        WebClientGraphQLClient client = MonoGraphQLClient.createWithWebClient(webClient);
//
//        //The GraphQLResponse contains data and errors.
//        Mono<GraphQLResponse> graphQLResponseMono = graphQLClient.reactiveExecuteQuery(query);
//
//        //GraphQLResponse has convenience methods to extract fields using JsonPath.
//        Mono<String> somefield = graphQLResponseMono.map(r -> r.extractValue("somefield"));
//
//        //Don't forget to subscribe! The request won't be executed otherwise.
//        somefield.subscribe();

        WebClientGraphQLClient webClientGraphQLClient = new WebClientGraphQLClient(WebClient.create("http://localhost:9090/graphql"));
        Mono<GraphQLResponse> test = webClientGraphQLClient.reactiveExecuteQuery("""
                {
                  shows {
                    title
                    releaseYear
                  }
                }
                """, Collections.emptyMap());
        System.out.println(test.block());
    }

}
