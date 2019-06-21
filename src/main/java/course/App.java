package course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author dlei(徐磊)
 * @Tel  18665616520
 * @Email dlei0009@163.com
 * @QQ 251425887
 * @Date 2017年7月23日下午8:06:42
 * @From http://www.fkjava.org 疯狂软件
 * @Version 1.0
 * @SpringBootApplication指定这是一个 spring boot的应用程序.
 */
@ServletComponentScan
@SpringBootApplication
@MapperScan("course.dao")
public class App extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

    public static void main( String[] args )
    {
    	// SpringApplication 用于从main方法启动Spring应用的类。
        SpringApplication.run(App.class, args);
    }
}
