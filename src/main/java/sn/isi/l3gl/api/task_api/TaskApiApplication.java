package sn.isi.l3gl.api.task_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {
		"sn.isi.l3gl.api",
		"sn.isi.l3gl.core"   // ← scan les @Service et @Repository de task-core
})
@EntityScan(basePackages = {
		"sn.isi.l3gl.api",
		"sn.isi.l3gl.core"   // ← scan les @Entity de task-core
})
@EnableJpaRepositories(basePackages = {
		"sn.isi.l3gl.api",
		"sn.isi.l3gl.core"   // ← scan les @Repository de task-core
})
//@SpringBootApplication
public class TaskApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApiApplication.class, args);
	}

}
