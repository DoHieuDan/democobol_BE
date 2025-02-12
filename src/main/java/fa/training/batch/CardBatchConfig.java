package fa.training.batch;

import fa.training.model.Card;
import fa.training.repository.CardRepository;
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
public class CardBatchConfig {

    private final CardRepository cardRepository;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

//    @Bean
//    public RepositoryItemReader<Card> cardReader(){
//        RepositoryItemReader<Card> reader = new RepositoryItemReader<>();
//        reader.setRepository(cardRepository);
//        reader.setMethodName("findAll");
//        reader.setPageSize(10);
//        reader.setSort(Collections.singletonMap("cardNum", Sort.Direction.ASC));
//        return reader;
//    }

    @Bean
    public FlatFileItemReader<Card> cardReader(){
        FlatFileItemReader<Card> reader = new FlatFileItemReader<>();
        reader.setName("carddata.txt");
        reader.setResource(new FileSystemResource("src/main/resources/data/carddata.txt"));
        reader.setLineMapper(lineMapperCard());
        return reader;
    }

    @Bean
    public ItemProcessor<Card, Card> cardProcessor(){
        return card -> {
            log.info("Processing: {}", card);
            return card;
        };
    }

    @Bean
    public ItemWriter<Card> cardWriter(){
        return items -> {};
    }

    @Bean
    public Step cardStep1(JobRepository job, FlatFileItemReader<Card> reader,
                          ItemProcessor<Card, Card> processor, ItemWriter<Card> writer) {
        return new StepBuilder("step", job)
                .<Card, Card>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean(name = "cardJob")
    public Job cardJob(Step cardStep1) {
        return new JobBuilder("cardJob", jobRepository)
                .start(cardStep1)
                .build();
    }

    private LineMapper<Card> lineMapperCard() {
        DefaultLineMapper<Card> lineMapper = new DefaultLineMapper<>();

        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setStrict(false);
        tokenizer.setNames(
                "cardNum",
                "acctId",
                "cardCvvCd",
                "embossedName",
                "expiryDate",
                "isActive"
        );
        tokenizer.setColumns(
                new Range(1, 16),
                new Range(17, 27),
                new Range(28, 30),
                new Range(31, 80),
                new Range(81, 90),
                new Range(91, 91)
        );

        BeanWrapperFieldSetMapper<Card> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Card.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
}
