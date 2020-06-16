package digital.paisley.embryo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable<U> {

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "create_time")
    protected Date createdDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "update_time")
    protected Date lastModifiedDate;

}