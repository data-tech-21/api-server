package currere.apiserver.domain.member.dto.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Pattern

data class SignUpRequest(
    @Schema(example = "김보겸")
    @field:Pattern(regexp = REGEXP_NAME, message = INVALID_NAME)
    val name: String = "",

    @field:Pattern(regexp = REGEXP_EMAIL, message = INVALID_EMAIL)
    val email: String = "",

    @field:Pattern(
        regexp = REGEXP_PASSWORD,
        message = INVALID_PASSWORD,
    )
    val password: String = "",
) {
    companion object {
        private const val REGEXP_NAME = """[가-힣]{2,}"""
        private const val REGEXP_EMAIL = """[a-z0-9]+@mju\.ac\.kr"""
        private const val REGEXP_PASSWORD = """[a-z0-9]+@mju\.ac\.kr"""
        private const val INVALID_NAME = "유효하지 않은 형식의 이름입니다."
        private const val INVALID_EMAIL = "유효하지 않은 형식의 이메일입니다."
        private const val INVALID_PASSWORD = "유효하지 않은 형식의 비밀번호입니다."
    }
}
