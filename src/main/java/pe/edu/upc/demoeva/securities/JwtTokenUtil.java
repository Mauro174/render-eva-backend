package pe.edu.upc.demoeva.securities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pe.edu.upc.demoeva.entities.Usuario;
import pe.edu.upc.demoeva.servicesinterfaces.IUsuarioService;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    // milisegundos (5 horas)
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private IUsuarioService usuarioService;

    // ============= OBTENER CLAIMS DEL TOKEN =============

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // IMPORTANTE: usamos el secret para parsear el token
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // ============= GENERAR TOKEN =============

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        // username = email del usuario
        String email = userDetails.getUsername();

        // usamos tu método que hace el @Query con LIKE
        List<Usuario> lista = usuarioService.buscarUsuario(email);
        Usuario u = null;
        if (lista != null && !lista.isEmpty()) {
            u = lista.get(0);  // tomamos el primero
        }

        if (u != null) {
            claims.put("idUsuario", u.getIdUsuario());
            claims.put("nombre", u.getNombreUsuario());
        } else {
            // por si acaso no se encontró
            claims.put("nombre", email);
        }

        // rol del usuario
        String roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());

        claims.put("role", roles);

        return doGenerateToken(claims, email);
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject) // aquí va el email
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(new SecretKeySpec(
                        Base64.getDecoder().decode(secret),
                        SignatureAlgorithm.HS512.getJcaName()
                ))
                .compact();
    }

    // ============= VALIDAR TOKEN =============

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
