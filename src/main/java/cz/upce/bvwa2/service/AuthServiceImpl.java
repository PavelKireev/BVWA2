package cz.upce.bvwa2.service;

import cz.upce.bvwa2.configuration.security.AuthUser;
import cz.upce.bvwa2.db.entity.Patient;
import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.model.auth.SignInModel;
import cz.upce.bvwa2.model.auth.SignUpModel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtEncoder encoder;
    private final PatientService patientService;

    @Override
    public String signIn(Authentication authentication, SignInModel model) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                                          .issuer("self")
                                          .issuedAt(now)
                                          .expiresAt(now.plusSeconds(expiry))
                                          .subject(authentication.getName())
                                          .claim("scope", scope)
                                          .claim("userId", authUser.getId())
                                          .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @Override
    @SneakyThrows
    public void signUp(SignUpModel model) {
        patientService.create(model);
    }
}
