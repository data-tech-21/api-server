package currere.apiserver.domain.member.domain

import currere.apiserver.global.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member")
class Member(
    @Column(nullable = true)
    val studentId: String,

    @Column(nullable = true)
    val name: String,

    @Column(nullable = true)
    val email: String,

    @Column(nullable = true)
    val password: String,
) : BaseEntity()
