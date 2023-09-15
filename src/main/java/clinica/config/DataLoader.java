package clinica.config;

import clinica.config.auth.AuthService;
import clinica.config.auth.RegisterRequest;
import clinica.entity.security.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
  private final AuthService authService;
  
  public DataLoader(AuthService authService) {
    this.authService = authService;
  }
  
  @Override
  public void run(ApplicationArguments args) {
    
    authService.register(
        RegisterRequest.builder()
            .username("admin")
            .email("admin@admin.com")
            .password("admin")
            .role(Role.ROLE_ADMIN)
            .build()
    );
  
    authService.register(
        RegisterRequest.builder()
            .username("user")
            .email("user@admin.com")
            .password("user")
            .role(Role.ROLE_USER)
            .build()
    );
  }
}
