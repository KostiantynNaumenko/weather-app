package springapiapp.weatherproject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springapiapp.api.domain.Root;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Root getRoot(String city) {

        Root root = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&appid=" + "d32264e0ae762b179dfd2e89c21efbbe", Root.class);
        return root;
    }
}
