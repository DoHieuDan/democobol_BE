package fa.training.batch.launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BatchJobLauncher implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    public BatchJobLauncher(JobLauncher jobLauncher, @Lazy Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("start", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}

