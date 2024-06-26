package dm.bl.erpservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableDiscoveryClient
@EnableFeignClients
@EnableKafka
@SpringBootApplication
public class ErpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpServiceApplication.class, args);
	}

}
