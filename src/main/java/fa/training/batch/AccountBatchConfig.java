package fa.training.batch;

import fa.training.model.AccountRecord;
import fa.training.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class AccountBatchConfig {

    private final AccountRepository accountRepository;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

//    @Bean
//    public RepositoryItemReader<AccountRecord> reader(){
//        RepositoryItemReader<AccountRecord> reader = new RepositoryItemReader<>();
//        reader.setRepository(accountRepository);
//        reader.setMethodName("findAll");
//        reader.setPageSize(10);
//        reader.setSort(Collections.singletonMap("acctId", Sort.Direction.ASC));
//        return reader;
//    }

    @Bean
    public FlatFileItemReader<AccountRecord> reader(){
        FlatFileItemReader<AccountRecord> reader = new FlatFileItemReader<>();
        reader.setName("acctdata.txt");
        reader.setResource(new FileSystemResource("src/main/resources/data/acctdata.txt"));
        reader.setLineMapper(lineMapperAccountRecord());
        return reader;
    }

    @Bean
    public ItemProcessor<AccountRecord, AccountRecord> processor(){
        return accountRecord -> {
            log.info("ACCT-ID                 :{}", accountRecord.getAcctId());
            log.info("ACCT-ACTIVE-STATUS      :{}", accountRecord.getAcctActiveStatus());
            log.info("ACCT-CURR-BAL           :{}", accountRecord.getAcctCurrBal());
            log.info("ACCT-CREDIT-LIMIT       :{}", accountRecord.getAcctCreditLimit());
            log.info("ACCT-CASH-CREDIT-LIMIT  :{}", accountRecord.getAcctCashCreditLimit());
            log.info("ACCT-OPEN-DATE          :{}", accountRecord.getAcctOpenDate());
            log.info("ACCT-EXPIRATION-DATE    :{}", accountRecord.getAcctExpiraionDate());
            log.info("ACCT-REISSUE-DATE       :{}", accountRecord.getAcctReissueDate());
            log.info("ACCT-CURR-CYC-CREDIT    :{}", accountRecord.getAcctCurrCycCredit());
            log.info("ACCT-CURR-CYC-DEBIT     :{}", accountRecord.getAcctCurrCycCredit());
            log.info("ACCT-GROUP-ID           :{}", accountRecord.getAcctGroupId());
            return accountRecord;
        };
    }

    @Bean
    public ItemWriter<AccountRecord> writer(){
//        RepositoryItemWriter<AccountRecord> writer = new RepositoryItemWriter<>();
//        writer.setRepository(accountRepository);
//        writer.setMethodName("save");
        return items -> {};
    }

    @Bean
    public Step step(JobRepository job, FlatFileItemReader<AccountRecord> reader,
                     ItemProcessor<AccountRecord, AccountRecord> processor, ItemWriter<AccountRecord> writer) {
        return new StepBuilder("step", job)
                .<AccountRecord, AccountRecord>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean(name = "accountJob")
    public Job accountJob(Step step) {
        return new JobBuilder("accountJob", jobRepository)
                .start(step)
                .build();
    }

    private LineMapper<AccountRecord> lineMapperAccountRecord() {
        DefaultLineMapper<AccountRecord> lineMapper = new DefaultLineMapper<>();

        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setStrict(false);
        tokenizer.setNames(
                "acctId",
                "acctActiveStatus",
                "acctCurrBal",
                "acctCreditLimit",
                "acctCashCreditLimit",
                "acctOpenDate",
                "acctExpiraionDate",
                "acctReissueDate",
                "acctCurrCycCredit",
                "acctCurrCycDebit",
                "acctGroupId",
                "acctAddrZip"
        );
        tokenizer.setColumns(
                new Range(1, 11),
                new Range(12, 12),
                new Range(13, 23),
                new Range(25, 35),
                new Range(37, 47),
                new Range(49, 58),
                new Range(59, 68),
                new Range(69, 78),
                new Range(79, 89),
                new Range(91, 101),
                new Range(103, 112),
                new Range(113, 122)
        );

        BeanWrapperFieldSetMapper<AccountRecord> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(AccountRecord.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }


}
