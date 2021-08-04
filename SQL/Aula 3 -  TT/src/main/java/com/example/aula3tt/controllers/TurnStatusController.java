package com.example.aula3tt.controllers;

import com.example.aula3tt.service.TurnStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turnstatus")
public class TurnStatusController {
    @Autowired
    private TurnStatusService turnStatusService;


}
