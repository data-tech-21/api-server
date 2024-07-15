package currere.apiserver.domain.member.api

import currere.apiserver.domain.member.application.MemberService
import currere.apiserver.domain.member.dto.request.SignInRequest
import currere.apiserver.domain.member.dto.request.SignUpRequest
import currere.apiserver.domain.member.dto.response.SignInResponse
import currere.apiserver.global.common.ApiResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
class MemberController(private val memberService: MemberService) : MemberApi {
    override fun signUp(@Valid @RequestBody request: SignUpRequest) {
        memberService.signUp(request)
    }

    override fun signIn(@Valid @RequestBody request: SignInRequest): ApiResponse<SignInResponse> {
        return ApiResponse.success(memberService.signIn(request))
    }
}
