package io.berndruecker.demo.scoring;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SomeJavaWorker {

    private static final String[] RISK_OPTIONS = {"low", "medium", "high"};
    private static int nextOption = 0;

    private static Logger logger = LoggerFactory.getLogger(SomeJavaWorker.class);

    @JobWorker(type = "calculateRisk")
    public Map<String, Object> calculateRisk(final ActivatedJob job) {
        Map<String, Object> variables = job.getVariablesAsMap();

        String firstname = (String) variables.get("firstname");
        String lastname = (String) variables.get("lastname");
        String email = (String) variables.get("email");
        Object zipCode = variables.get("zipcode");
        Number loanAmount = (Number) variables.get("loanAmount");

        String riskAssessment = RISK_OPTIONS[nextOption];
        nextOption++;
        if (nextOption>2) { nextOption = 0; }

        System.out.println("####");
        System.out.println("Calculated some random risk assessment: " + riskAssessment + " - request: " + variables);
        System.out.println("####");

        HashMap<String, Object> result = new HashMap<>();
        result.put("risk", riskAssessment);
        return result;
    }

}

