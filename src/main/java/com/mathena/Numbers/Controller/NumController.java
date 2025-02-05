package com.mathena.Numbers.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class NumController {

    @GetMapping("/classify-number")
    public ResponseEntity<Map<String, Object>> classifyNumber(@RequestParam String number) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            int num = Integer.parseInt(number);
            response.put("number", num);
            response.put("is_prime", isPrime(num));
            response.put("is_perfect", isPerfect(num));
            response.put("digit_sum", getDigitSum(num));
            response.put("properties", getProperties(num));
            response.put("fun_fact", getFunFact(num));
            
            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            response.put("number", number);
            response.put("error", "Invalid input. Please enter a valid number.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private boolean isPerfect(int num) {
        int sum = 1; 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num && num != 1;
    }

    private int getDigitSum(int num) {
        return String.valueOf(num).chars().map(Character::getNumericValue).sum();
    }

    private List<String> getProperties(int num) {
        List<String> properties = new ArrayList<>();
        if (isArmstrong(num)) properties.add("armstrong");
        properties.add(num % 2 == 0 ? "even" : "odd");
        return properties;
    }

    private boolean isArmstrong(int num) {
        int originalNum = num, sum = 0, n = String.valueOf(num).length();
        while (num != 0) {
            sum += Math.pow(num % 10, n);
            num /= 10;
        }
        return sum == originalNum;
    }

    private String getFunFact(int num) {
        try {
            String url = "http://numbersapi.com/" + num + "/math";
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Could not retrieve a fun fact at this time.";
        }
    }
}
