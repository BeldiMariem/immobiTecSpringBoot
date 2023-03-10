package immobi.tec.immobitec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_property;

    private String description ;
    private Boolean closed ;

    @Enumerated(EnumType.STRING)
    private TypeProperty type ;
    private String Picture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Announcement announcement;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Appointement> appointements;

    // Rendez vous

}
