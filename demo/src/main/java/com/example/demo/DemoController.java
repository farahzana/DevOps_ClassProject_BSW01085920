package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/")
    public Map<String, String> getInfo() {
        Map<String, String> data = new HashMap<>();
        
        // In Kubernetes, the 'HOSTNAME' environment variable is automatically 
        // set to the unique name of the Pod.
        String podName = System.getenv().getOrDefault("HOSTNAME", "Running Locally (No Pod)");

        data.put("message", "Hello DevOps! Your API is alive.");
        data.put("pod_name", podName);
        data.put("status", "Healthy");
        
        return data;
    }
}