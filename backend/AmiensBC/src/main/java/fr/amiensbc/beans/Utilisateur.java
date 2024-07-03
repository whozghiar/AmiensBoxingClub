package fr.amiensbc.beans;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "utilisateur")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Schema(description = "Description d'un utilisateur")
public class Utilisateur implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "id")
    private Long id;

    // Informations personnelles
    @Schema(description = "Nom de l'utilisateur", example = "Doe")
    @Column(name = "nom")
    private String nom;

    @Schema(description = "Prénom de l'utilisateur", example = "John")
    @Column(name = "prenom")
    private String prenom;

    @Schema(description = "Date de naissance de l'utilisateur", example = "2000-01-01")
    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Schema(description = "Sexe de l'utilisateur", example = "M")
    @Column(name = "sexe")
    private String sexe;

    @Lob
    @Schema(description = "Photo de l'utilisateur en base 64", example = "%PNG-test")
    @Column(name = "photo")
    private String photo;

    // Informations de connexion
    @Schema(description = "Login de l'utilisateur", example = "johndoe")
    @Column(name = "email")
    private String email;

    @Schema(description = "Mot de passe de l'utilisateur", example = "password")
    @Column(name = "mot_de_passe")
    private String password;


 // Liaisons avec les autres tables

    // Informations complémentaires
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "coordonnees_id")
    private Coordonnees coordonnees;

    // Liaison avec la licence
    @Schema(description = "Licence de l'utilisateur")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "licence_id")
    private Licence licence;


    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
