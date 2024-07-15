package currere.apiserver.domain.member.dto.request

import jakarta.validation.constraints.NotBlank

data class SignInRequest(
    @field:NotBlank(message = "학번을 입력해 주세요.")
    val studentId: String = "",

    @field:NotBlank(message = "비밀번호를 입력해 주세요.")
    val password: String = "",
)
