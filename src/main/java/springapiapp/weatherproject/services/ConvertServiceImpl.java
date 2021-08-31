package springapiapp.weatherproject.services;

import org.springframework.stereotype.Service;
import springapiapp.api.domain.Root;
import springapiapp.weatherproject.model.ConvertedRoot;
import springapiapp.weatherproject.model.Coord;
import springapiapp.weatherproject.model.Weather;

import java.time.LocalDate;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public ConvertedRoot convert(Root root) {

        Coord coord = new Coord(root.coord.lat,
                root.coord.lon);

        Weather weather = new Weather(root.weather.get(0).main,
                root.weather.get(0).description,
                root.weather.get(0).icon);

        ConvertedRoot convertedRoot = new ConvertedRoot(root.name,
                LocalDate.now(), coord, weather);

        return convertedRoot;
    }
}
