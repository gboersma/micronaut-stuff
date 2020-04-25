package info.leadinglight.mjob.greeting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="greeting")
public class GreetingEntity {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    @Column(name="greeting")
    private String greeting;
}
