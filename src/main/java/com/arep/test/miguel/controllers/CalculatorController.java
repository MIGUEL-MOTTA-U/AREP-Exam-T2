package com.arep.test.miguel.controllers;

import com.arep.test.miguel.models.ApiResponse;
import com.arep.test.miguel.services.interfaces.CalculatorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;


@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final boolean isProxy = false;

    private final RestClient restClient;
    private final RestClient pasiveClient;

    public CalculatorController(CalculatorService calculatorService, RestClient.Builder restClientBuilder) {
        this.calculatorService = calculatorService;
        this.restClient = restClientBuilder.baseUrl("").build();
        this.pasiveClient = restClientBuilder.baseUrl("").build();
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/tribseq")
    public ResponseEntity<ApiResponse> tribonacciSeq(@RequestParam int value) {
        if (isProxy) {
            try {
                return ResponseEntity.status(200).body(this.restClient.get().uri("/api/calculator/tribseq?value="+value).retrieve().body(ApiResponse.class));
            } catch (Exception e) {
                return ResponseEntity.status(200).body(this.pasiveClient.get().uri("/api/calculator/tribseq?value="+value).retrieve().body(ApiResponse.class));
            }

        }
        List<Integer> result = calculatorService.calculateTribonacci(value);
        return ResponseEntity.status(200).body(new ApiResponse("Secuencia de Tribonacci", value, result));
    }


}
