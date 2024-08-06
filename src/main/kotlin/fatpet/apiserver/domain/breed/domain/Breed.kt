package fatpet.apiserver.domain.breed.domain

import fatpet.apiserver.global.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "breed")
class Breed(
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val species: Species,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val sex: Sex,

    @Column(nullable = false)
    val nameEng: String,

    @Column(nullable = false)
    val nameKor: String,

    @Column(nullable = false)
    var code: Int,

    @Column
    var avgWeightLow: Int,

    @Column
    var avgWeightHigh: Int,
) : BaseEntity()
