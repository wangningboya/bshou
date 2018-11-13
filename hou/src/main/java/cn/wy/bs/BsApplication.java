package cn.wy.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="cn.wy.bs.mapper")
public class BsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsApplication.class, args);
	}
}
