package org.example.microcuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCuentaApplication.class, args);
	}

}
