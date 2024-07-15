package currere.apiserver.domain.member.api

import currere.apiserver.domain.member.dto.request.SignInRequest
import currere.apiserver.domain.member.dto.request.SignUpRequest
import currere.apiserver.domain.member.dto.response.SignInResponse
import currere.apiserver.global.common.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Tag(name = "Member API")
interface MemberApi {
    @Operation(summary = "회원가입")
    @PostMapping("/sign-up")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun signUp(request: SignUpRequest)

    @Operation(summary = "로그인")
    @PostMapping("/sign-in")
    @ResponseStatus(value = HttpStatus.OK)
    fun signIn(request: SignInRequest): ApiResponse<SignInResponse>
}
