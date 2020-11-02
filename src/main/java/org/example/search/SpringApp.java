package org.example.search;

import org.example.search.service.BookService;
import org.example.search.service.impl.DefaultBookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //автоконфигурация, управление жизненным циклом компонентов приложения
//@AllArgsConstructor
//@EnableElasticsearchRepositories
//@EnableScheduling
//@Component
public class SpringApp {

	/*@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}

	//BookService.create(new Book("Первая аннотация", "Первый автор", "Первое название", "2017"));

	/*@PostConstruct
	public void perform() throws Exception {
		JobParameters params = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, params);
	}*/

	/*@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8087");
	}*/
}