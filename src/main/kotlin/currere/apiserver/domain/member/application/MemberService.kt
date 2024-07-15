package currere.apiserver.domain.member.application

import currere.apiserver.domain.member.dao.MemberRepository
import currere.apiserver.domain.member.domain.Member
import currere.apiserver.domain.member.dto.request.SignInRequest
import currere.apiserver.domain.member.dto.request.SignUpRequest
import currere.apiserver.domain.member.dto.response.SignInResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    @Transactional
    fun signUp(request: SignUpRequest) {
        val member = Member(
            name = request.name,
            email = request.email,
            password = request.password
        )

        memberRepository.save(member)
    }

    @Transactional(readOnly = true)
    fun signIn(request: SignInRequest): SignInResponse {
        val member = memberRepository.findByEmail(request.email)?.takeIf { member ->
            member.password == request.password
        } ?: throw IllegalArgumentException("이메일 또는 비밀번호를 확인해 주세요.")

        return SignInResponse(
            accessToken = "accessToken",
            refreshToken = "refreshToken"
        )
    }
}
