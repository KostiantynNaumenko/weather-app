package springapiapp.weatherproject.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springapiapp.api.domain.Root;
import springapiapp.weatherproject.model.ConvertedRoot;
import springapiapp.weatherproject.services.ApiService;
import springapiapp.weatherproject.services.ConvertService;
import springapiapp.weatherproject.services.RootService;

/**
 * Created by jt on 9/22/17.
 */
@Slf4j
@Controller
public class WeatherController {

    private final ApiService apiService;
    private final ConvertService convertService;
    private final RootService rootService;

    public WeatherController(ApiService apiService, ConvertService convertService, RootService rootService) {
        this.apiService = apiService;
        this.convertService = convertService;
        this.rootService = rootService;
    }

    @GetMapping({"/list", "", "/"})
    public String formPost(Model model){
        model.addAttribute("roots", rootService.findAll());

        return "weather";
    }


    @RequestMapping(value = "/{city_name}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public ConvertedRoot getConvertedRoot(Model model, @PathVariable String city_name){
        String city = city_name;

        log.debug("Received City value: " + city);
        //default if null or zero
        if(city == null){
            log.debug("Setting City value to Kyiv");

            city = "Kyiv";
        }

        Root root = apiService.getRoot(city);
        ConvertedRoot convertedRoot = convertService.convert(root);
        rootService.save(convertedRoot);
        model.addAttribute("root", convertedRoot);

        return convertedRoot;
    }
}
