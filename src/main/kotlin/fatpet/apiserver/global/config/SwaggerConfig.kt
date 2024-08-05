package fatpet.apiserver.global.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun swaggerApi(): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("currere API Documentation")
                .description("팻펫v2 API 문서")
                .version("0.0.0"),
        )
}
