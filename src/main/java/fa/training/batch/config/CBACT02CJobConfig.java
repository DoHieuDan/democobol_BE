package fa.training.batch.config;

import fa.training.mapper.CBACT01CMapper;
import fa.training.model.AccountRecord;
import lombok.Getter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CBACT02CJobConfig {

    @Getter
    @Component
    public static class AccountRecordStorage {
        private final List<AccountRecord> accountRecords = new ArrayList<>();

        public void addAll(List<? extends AccountRecord> records) {
            accountRecords.addAll(records);
        }
    }

//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=false")
//                .username("sa")
//                .password("KhangNV19@135")
//                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
//                .build();
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Job exampleJob(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          ItemReader<AccountRecord> reader,
                          ItemProcessor<AccountRecord, AccountRecord> processor,
                          ItemWriter<AccountRecord> writer) {
        Step step = new StepBuilder("ACCTFILE", jobRepository)
                .<AccountRecord, AccountRecord>chunk(1, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
        return new JobBuilder("READACCT", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step).build();
    }

    @Bean
    public FlatFileItemReader<AccountRecord> accountReader() {
        return new FlatFileItemReaderBuilder<AccountRecord>()
                .name("fileItemReader")
                .resource(new FileSystemResource("src/main/resources/acctdata.txt"))
                .lineMapper(new CBACT01CMapper.CBACT01CLMapper())
                .build();
    }

    @Bean
    public ItemProcessor<AccountRecord, AccountRecord> accountProcessor() {
        return item -> item;
    }



    @Bean
    public ItemWriter<AccountRecord> accountWriter(CBACT01CJobConfig.AccountRecordStorage storage) {
        return items -> storage.addAll(items.getItems());
    }

//    @Bean
//    public ItemWriter<AccountRecord> writer() {
//        return items -> items.forEach(System.out::println);
//    }
}
