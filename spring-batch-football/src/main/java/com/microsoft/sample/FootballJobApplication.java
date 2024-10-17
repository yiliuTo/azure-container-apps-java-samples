package com.microsoft.sample;

import java.util.Date;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
@Configuration
@ComponentScan("org.springframework.batch.samples.football")
public class FootballJobApplication implements CommandLineRunner {

	private final static Logger LOGGER = LoggerFactory.getLogger(FootballJobApplication.class);


	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Autowired
	private DataSource ds;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FootballJobApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int count = JdbcClient.create(new JdbcTemplate(ds)).sql("SELECT COUNT(0) FROM PLAYER_SUMMARY")
			.query(Integer.class).single();
		LOGGER.info("There is {} player summary before job execution", count);

		jobLauncher.run(job, new JobParameters());

		count = JdbcClient.create(new JdbcTemplate(ds)).sql("SELECT COUNT(0) FROM PLAYER_SUMMARY").query(Integer.class)
			.single();
		LOGGER.info("There is {} player summary after job execution", count);

		ResultReport result = new ResultReport();
		result.setLastExecuted(new Date());
		result.setSummaryCount(count);
	}

}
