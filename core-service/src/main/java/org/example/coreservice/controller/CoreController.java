package org.example.coreservice.controller;

import org.example.coreservice.model.CoreRequest;
import org.example.coreservice.model.CoreResponse;
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
    public ResponseEntity<CoreResponse> processPayment(@RequestBody CoreRequest coreRequest) {
        CoreResponse coreResponse = coreService.processPayment(coreRequest);

        return ResponseEntity.ok(coreResponse);
    }
}

