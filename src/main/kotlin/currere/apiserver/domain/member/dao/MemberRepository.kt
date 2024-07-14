package currere.apiserver.domain.member.dao

import currere.apiserver.domain.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>
