package ua.com.gosox.domains;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "gosox", name = "PRODUCT")
@Getter
@Setter
public class DeliveryType {
}
