package currere.apiserver.domain.member.domain

import currere.apiserver.global.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member")
class Member(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,
) : BaseEntity()
