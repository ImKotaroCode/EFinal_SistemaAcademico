package idat.pe.efinal_alexanderfr.dto.response;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class LoginResponse {
    private String token;
    private String username;
    private List<String> roles;
}
