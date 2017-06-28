package cl.chinaski.primerdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cl.chinaski.primerdemo.entities.SocialMedia;

@RestController
public class PrimerDemoController {
	String urlGet = "https://platziprofesores.herokuapp.com/v1/socialMedias/";
	RestTemplate restTemplate;
	MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

	PrimerDemoController(){
		restTemplate = new RestTemplate();
		mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
	}
	
	@RequestMapping("/")
	public String llamaOtroREST() {
        ResponseEntity<List<SocialMedia>> socialMediaResponse;
        
        socialMediaResponse = restTemplate.exchange(urlGet, HttpMethod.GET, null, new ParameterizedTypeReference<List<SocialMedia>>() {});
        List<SocialMedia> socialMedias = socialMediaResponse.getBody();
        
        for(SocialMedia sm : socialMedias){
        	System.out.println(sm.getIdSocialMedia());
        	System.out.println(sm.getName());
        	System.out.println(sm.getIcon());
        }
        
        return "SocialMedias recibidos :)";
        
    }
}
