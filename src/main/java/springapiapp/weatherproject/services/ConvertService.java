package springapiapp.weatherproject.services;

import springapiapp.api.domain.Root;
import springapiapp.weatherproject.model.ConvertedRoot;

public interface ConvertService {

    ConvertedRoot convert(Root root);
}
