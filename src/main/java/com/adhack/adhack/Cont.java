package com.adhack.adhack;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class Cont {


    @RequestMapping("/test")
    public ResponseEntity test(){

        return new ResponseEntity(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }
}
