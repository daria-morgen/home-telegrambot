package home.questionnaire.reactiveWebClient;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GreetingWebClient {
	private WebClient client = WebClient.create("http://localhost:8080");

	/*
	 * The Spring MVC RestTemplate class is, by nature, blocking.
	 * Consequently, we don’t want to use it in a reactive application.
	 * For reactive applications, Spring offers the WebClient class, which is non-blocking.
	 */

	private Mono<ClientResponse> result = client.get()
			.uri("/hello")
			.accept(MediaType.TEXT_PLAIN)
			.exchange();

	public String getResult() {
		return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
