package cl.chinaski.primerdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cl.chinaski.primerdemo.entities.Quote;

@RestController
public class PrimerDemoController {
	@RequestMapping("/")
	public String llamaOtroREST() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote.toString();
    }
}
