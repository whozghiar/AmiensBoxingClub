package fr.amiensbc.services;


import fr.amiensbc.DTOs.LoginUserDTO;
import fr.amiensbc.beans.Utilisateur;
import fr.amiensbc.repositories.UtilisateurRepository;
import fr.amiensbc.DTOs.RegisterUserDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UtilisateurRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UtilisateurRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Utilisateur signup(RegisterUserDTO input) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(input.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(input.getPassword()));
        utilisateur.setPrenom(input.getName());

        return userRepository.save(utilisateur);
    }

    public Utilisateur authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
