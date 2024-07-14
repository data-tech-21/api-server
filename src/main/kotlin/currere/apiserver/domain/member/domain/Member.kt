package currere.apiserver.domain.member.domain

import currere.apiserver.global.common.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member")
class Member : BaseEntity()
