package io.berndruecker.demo.scoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Deployment(resources = "classpath:customer-onboarding.bpmn")
public class DemoWorkerSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWorkerSpringbootApplication.class, args);
	}


}
