package ua.com.gosox.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "gosox", name = "DELIVERY_TYPE")
@Getter
@Setter
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String name;


}
