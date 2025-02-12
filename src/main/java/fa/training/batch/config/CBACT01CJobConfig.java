package fa.training.batch.config;

import fa.training.mapper.CBACT01CMapper;
import fa.training.model.AccountRecord;
import lombok.Getter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class CBACT01CJobConfig {

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
                          ItemReader<AccountRecord> accountReader,
                          ItemProcessor<AccountRecord, AccountRecord> accountProcessor,
                          CompositeItemWriter<AccountRecord> accountWriterAPIConsole) {
        Step step = new StepBuilder("ACCTFILE", jobRepository)
                .<AccountRecord, AccountRecord>chunk(1, transactionManager)
                .reader(accountReader)
                .processor(accountProcessor)
                .writer(accountWriterAPIConsole)
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
    public ItemWriter<AccountRecord> accountWriterAPI(AccountRecordStorage storage) {
        return items -> storage.addAll(items.getItems());
    }

    @Bean
    public FlatFileItemWriter<AccountRecord> accountWriter() {
        return new FlatFileItemWriterBuilder<AccountRecord>()
                .name("AccountOutput")
                .resource(new FileSystemResource("src/main/resources/acctoutput.txt"))
                .lineAggregator(new CBACT01CMapper.CBACT01CLAggregator())
                .build();
    }


    @Bean
    public ItemWriter<AccountRecord> accountWriterConsole() {
        return items -> items.forEach(System.out::println);
    }

    @Bean
    public CompositeItemWriter<AccountRecord> accountWriterAPIConsole(
            FlatFileItemWriter<AccountRecord> accountWriter,
            ItemWriter<AccountRecord> accountWriterAPI,
            ItemWriter<AccountRecord> accountWriterConsole) {
        CompositeItemWriter<AccountRecord> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(Arrays.asList(accountWriter, accountWriterAPI, accountWriterConsole));
        return compositeItemWriter;
    }
}
