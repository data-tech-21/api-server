package currere.apiserver.domain.member.api

import currere.apiserver.domain.member.dto.request.SigninRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Tag(name = "Member API")
interface MemberApi {
    @Operation(summary = "회원가입")
    @PostMapping("/signin")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun signin(request: SigninRequest)
}
