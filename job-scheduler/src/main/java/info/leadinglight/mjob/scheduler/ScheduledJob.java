package info.leadinglight.mjob.scheduler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="job_schedule")
public class ScheduledJob {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getArgsJson() {
        return argsJson;
    }

    public void setArgsJson(String argsJson) {
        this.argsJson = argsJson;
    }

    public JobArguments getArgs() {
        return args;
    }

    public void setArgs(JobArguments args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "ScheduledJob{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", definition='" + definition + '\'' +
            ", argsJson='" + argsJson + '\'' +
            ", args=" + args +
            '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="definition")
    private String definition;

    @Column(name="args_json")
    private String argsJson;

    @Transient
    private JobArguments args;
}
