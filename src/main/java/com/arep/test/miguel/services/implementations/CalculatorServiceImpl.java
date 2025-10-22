package com.arep.test.miguel.services.implementations;

import com.arep.test.miguel.services.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    private final Map<Integer, Integer> calculatedValues = new HashMap<>();
    @Override
    public List<Integer> calculateTribonacci(int n) {
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            int t = calculateT(i);
            results.add(t);
        }
        return results;
    }

    public int calculateT(int n) {
        int result = calculatedValues.containsKey(n) ? calculatedValues.get(n) : tribonacci(n);
        calculatedValues.put(n, result);
        return result;
    }

    /*
     *
     * T(0) = 0
     * T(1) = 0
     * T(2) = 1
     * T(n) = T(n-1) + T(n-2) + T(n-3)
     * */
    private int tribonacci(int n) {
        if (n < 0) throw new RuntimeException("The value of n must be positive");
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        return tribonacci(n - 1) + tribonacci(n-2) + tribonacci(n - 3);
    }


}
