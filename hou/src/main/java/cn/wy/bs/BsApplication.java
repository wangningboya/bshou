package cn.wy.bs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="cn.wy.bs.mapper")
public class BsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsApplication.class, args);
	}
}
