package com.example.gateway.controller;



import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demo")
@CommonsLog
public class Controller {

    @GetMapping("/transfer")
    public List<?> search(@RequestParam Optional<String> q) {
        log.info(q);
        return Collections.emptyList();
    }


}