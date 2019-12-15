package vss.spring.trans.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String surname;
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private UserAccount account;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Phone> phoneNumbers = new ArrayList<>();
}
