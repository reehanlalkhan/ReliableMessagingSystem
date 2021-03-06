package in.novopay.messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MessagingCoreApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/*@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(MessagingCoreApplication.class, args);
	}

}
