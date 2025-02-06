package fa.training.model;

import fa.training.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "last_login")
    private Date lastLogin;

    private String role;

    @Column(name = "is_block")
    private boolean isBlock;

    @Transient
    private String token;

//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//    private RefreshToken rfToken;
//    @Transient
//    private String rfTokenString;

//    @Override
//    public String toString() {
//        return rfTokenString + " " + id;
//    }

}
