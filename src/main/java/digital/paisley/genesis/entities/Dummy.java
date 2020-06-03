package digital.paisley.genesis.entities;

import lombok.*;

import static javax.persistence.GenerationType.IDENTITY;

// Generated 17-oct-2015 20:38:39 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Dummy implements java.io.Serializable {

    private static final long serialVersionUID = -4497997807305980954L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "dummy", nullable = false, length = 20)
    private String dummy;

}
