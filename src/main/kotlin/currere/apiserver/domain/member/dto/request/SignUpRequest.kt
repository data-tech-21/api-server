package currere.apiserver.domain.member.dto.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Pattern

data class SignUpRequest(
    @Schema(example = "김보겸")
    @field:Pattern(regexp = """[가-힣]{2,}""", message = INVALID_NAME)
    val name: String = "",

    @field:Pattern(regexp = """[a-z0-9]+@mju\.ac\.kr""", message = INVALID_EMAIL)
    val email: String = "",

    @field:Pattern(
        regexp = """(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9_!@#$%^*+=-]{8,20}""",
        message = INVALID_PASSWORD,
    )
    val password: String = "",
) {
    companion object {
        private const val INVALID_NAME = "유효하지 않은 형식의 이름입니다."
        private const val INVALID_EMAIL = "유효하지 않은 형식의 이메일입니다."
        private const val INVALID_PASSWORD = "유효하지 않은 형식의 비밀번호입니다."
    }
}
