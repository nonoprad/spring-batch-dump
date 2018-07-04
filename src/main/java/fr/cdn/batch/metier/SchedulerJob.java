package fr.cdn.batch.metier;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerJob {


    private JobLauncher jobLauncher;

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    public SchedulerJob(JobLauncher jobLauncher, JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobLauncher = jobLauncher;
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Scheduled(cron = "1 * * * * *")
    public void runAJob() throws Exception {
        jobLauncher.run(jobBuilderFactory.get("Abandonne_EER").start(step1()).next(step2()).build(),new JobParameters());
    }

    @Bean
    private Step step2() {
        return this.stepBuilderFactory.get("check").tasklet((contribution, context) -> RepeatStatus.FINISHED).allowStartIfComplete(true).build();
    }

    @Bean
    protected Step step1() throws Exception {
        return this.stepBuilderFactory.get("Update").tasklet((contribution, context) -> RepeatStatus.FINISHED).allowStartIfComplete(true).build();
    }


}
