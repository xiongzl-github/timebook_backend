package top.timebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiongzl
 */
@MapperScan("top.timebook.mapper")
@SpringBootApplication
public class TimebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimebookApplication.class, args);
    }

}
