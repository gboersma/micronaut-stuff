package info.leadinglight.mquartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import java.util.Date;
import java.util.Map;

public class QuartzBuilder {
    public static JobBuilder jobBuilder(Class<? extends Job> jobClass, String name) {
        return jobBuilder(jobClass, name, name, null);
    }

    public static JobBuilder jobBuilder(Class<? extends Job> jobClass, String name, String group) {
        return jobBuilder(jobClass, name, group, null);
    }

    public static JobBuilder jobBuilder(Class<? extends Job> jobClass, JobKey jobKey) {
        return jobBuilder(jobClass, jobKey, null);
    }

    public static JobBuilder jobBuilder(Class<? extends Job> jobClass, String name, Map<String,Object> data) {
        return jobBuilder(jobClass, name, name, data);
    }

    public static JobBuilder jobBuilder(Class<? extends Job> jobClass, String name, String group, Map<String,Object> data) {
        JobKey jobKey = new JobKey(name, group);
        return jobBuilder(jobClass, jobKey, data);
    }

    public static JobBuilder jobBuilder(Class<? extends Job> jobClass, JobKey jobKey, Map<String,Object> data) {
        JobDataMap jobDataMap = new JobDataMap();
        if (data != null) {
            jobDataMap.putAll(data);
        }
        JobBuilder builder = JobBuilder.newJob(jobClass).withIdentity(jobKey).usingJobData(jobDataMap);
        return builder;
    }

    public static TriggerBuilder triggerBuilder(String name) {
        TriggerKey triggerKey = new TriggerKey(name, name);
        return triggerBuilder(triggerKey);
    }

    public static TriggerBuilder triggerBuilder(String name, String group) {
        TriggerKey triggerKey = new TriggerKey(name, group);
        return triggerBuilder(triggerKey);
    }

    public static TriggerBuilder triggerBuilder(TriggerKey triggerKey) {
        TriggerBuilder builder = triggerBuilder(triggerKey, new Date());
        return builder;
    }

    public static TriggerBuilder triggerBuilder(TriggerKey triggerKey, Date startTime) {
        TriggerBuilder builder = TriggerBuilder.newTrigger().withIdentity(triggerKey).startAt(startTime);
        return builder;
    }

    public static TriggerBuilder triggerBuilder(TriggerKey triggerKey, Date startTime, Date endTime) {
        TriggerBuilder builder = TriggerBuilder.newTrigger().withIdentity(triggerKey).startAt(startTime).endAt(endTime);
        return builder;
    }

    public static TriggerBuilder triggerBuilder(TriggerKey triggerKey, ScheduleBuilder scheduleBuilder) {
        TriggerBuilder builder = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder);
        return builder;
    }
}
