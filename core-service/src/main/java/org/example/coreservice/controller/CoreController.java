package org.example.coreservice.controller;

import org.example.coreservice.model.Request;
import org.example.coreservice.model.Response;
import org.example.coreservice.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core")
public class CoreController {

    private final CoreService coreService;

    @Autowired
    public CoreController(CoreService coreService) {
        this.coreService = coreService;
    }

    @PostMapping("/service")
    public ResponseEntity<Response> processPayment(@RequestBody Request request) {
        Response response = coreService.processPayment(request);

        return ResponseEntity.ok(response);
    }
}

