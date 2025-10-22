package com.arep.test.miguel.controllers;

import com.arep.test.miguel.models.ApiResponse;
import com.arep.test.miguel.services.interfaces.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/tribseq")
    public ResponseEntity<ApiResponse> tribonacciSeq(@RequestParam int value) {
        List<Integer> result = calculatorService.calculateTribonacci(value);
        return ResponseEntity.status(200).body(new ApiResponse("Secuencia de Tribonacci", value, result));
    }


}
