package cn.wy.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages="cn.wy.bs.mapper")
public class BsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsApplication.class, args);
	}
}
