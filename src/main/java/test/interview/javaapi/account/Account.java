package test.interview.javaapi.account;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_accounts")
public class Account {
    @Id
//    @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
    private Long id;
    @NotNull
    @Size(min = 3, max = 150)
    private String name;
    @NotNull
    @Size(min = 9, max = 12)
    private String phone;
    @NotEmpty
    @Size(max = 200)
    private String email;
    @Size(max = 200)
    private String address;
    @Size(max = 56)
    @NotEmpty
    private String country;
    @Size(max = 56)
    @NotEmpty
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
