package com.canvas.notification.pushnotification;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "https://rollcall.instructure.com")
public class PushNotificationController {


    @PostMapping("/webhook")
    public ResponseEntity<String> sendNotification(@RequestBody WebhookPayload payload){

        String url = payload.getUrl();
        String message = payload.getMessage();

        System.out.println("hello world!");
        // Define request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Define the request body
        String requestBody = "{\"AZ46565\": \"" + message + "\"}";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create the POST request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        // Return the response received from the third-party API
        return response;
    }
    @GetMapping("/webhook")
    public String webhookTest(){
        return "Up running";
    }


}
