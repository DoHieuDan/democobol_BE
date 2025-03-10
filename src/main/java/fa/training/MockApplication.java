package fa.training;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("cardJob")
	private Job cardJob;

	@Autowired
	@Qualifier("accountJob")
	private Job accountJob;

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("timeslap", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(accountJob, jobParameters);
	}
}
