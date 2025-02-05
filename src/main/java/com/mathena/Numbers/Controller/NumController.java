package com.mathena.Numbers.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class NumController {

    @GetMapping("/classify-number")
    public Map<String, Object> classifyNumber(@RequestParam String number) {
        Map<String, Object> response = new HashMap<>();
        try {
            int num = Integer.parseInt(number);
            response.put("number", num);
            response.put("is_prime", isPrime(num));
            response.put("is_perfect", isPerfect(num));
            response.put("digit_sum", getDigitSum(num));
            response.put("properties", getProperties(num));
            response.put("fun_fact", getFunFact(num));
            return response;
        } catch (NumberFormatException e) {
            response.put("number", number);
            response.put("error", true);
            return response;
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
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
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
        String url = "http://numbersapi.com/" + num + "/math";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
