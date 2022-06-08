package shop.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import shop.music.controller.ProductController;
import shop.music.model.Product;
import shop.music.service.ProductService;

@SpringBootApplication()
public class MusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
		System.out.println("done!");
	}

}
