package currere.apiserver.domain.member.api

import currere.apiserver.domain.member.dto.request.SigninRequest
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
class MemberController : MemberApi {
    override fun signin(@Valid @RequestBody request: SigninRequest) {
        TODO("Not yet implemented")
    }
}
