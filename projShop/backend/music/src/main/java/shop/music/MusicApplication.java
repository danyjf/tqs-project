package shop.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//remover o exclude depois de configurar a base de dados
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
		System.out.println("done!");
	}

}
