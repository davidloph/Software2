package co.edu.uco.utilidades_ms.infrastructure.primaryadapters.api.rest.utilidades;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class OAuthController {

    private static final String GOOGLE_VALIDATION_URL = "https://oauth2.googleapis.com/tokeninfo?id_token={idToken}";

    @PostMapping("/oauth")
    public ResponseEntity<Map<String, Object>> autenticar(@RequestBody Map<String, String> body) {
        String idToken = body.get("idToken");

        // Llama a Google para verificar el token
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> googleResponse = restTemplate.getForObject(
                GOOGLE_VALIDATION_URL, Map.class, idToken);

        // Extrae el email verificado
        String email = (String) googleResponse.get("email");

        return ResponseEntity.ok(Map.of("email", email));
    }
}