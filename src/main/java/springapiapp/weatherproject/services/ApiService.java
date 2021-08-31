package springapiapp.weatherproject.services;

import springapiapp.api.domain.Root;

public interface ApiService {

    Root getRoot(String city);
}
