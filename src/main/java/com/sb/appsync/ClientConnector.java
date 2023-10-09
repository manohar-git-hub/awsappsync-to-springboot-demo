package com.sb.appsync;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class ClientConnector {

	public void getUSerDetailsFromAWSAppSync() {
		WebClient.RequestBodySpec requestBodySpec = WebClient.builder()
				.baseUrl("https://s64of4khyfb47oww2cccp2db5a.appsync-api.ap-south-1.amazonaws.com/graphql")
				.defaultHeader("x-api-key", "da2-jgq3uxn2fnfibowgnr5bficu6u").build().method(HttpMethod.POST);

		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("query", "query MyQuery {\r\n" + "  getUser(id: \"1\") {\r\n" + "    rating\r\n"
				+ "    title\r\n" + "  }\r\n" + "}");

		WebClient.ResponseSpec response = requestBodySpec.body(BodyInserters.fromValue(requestBody))
				.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML).acceptCharset(StandardCharsets.UTF_8)
				.retrieve();

		Flux<String> bodyString = response.bodyToFlux(String.class);
		bodyString.subscribe(System.out::println);
	}

}
