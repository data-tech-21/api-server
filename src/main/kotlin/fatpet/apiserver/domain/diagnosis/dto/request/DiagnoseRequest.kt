package fatpet.apiserver.domain.diagnosis.dto.request

import fatpet.apiserver.domain.breed.domain.Sex
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class DiagnoseRequest(
    @field:NotNull(message = "품종 코드는 필수 입력값입니다.")
    val breedCode: Int,

    @field:NotNull(message = "성별은 필수 입력값입니다.")
    val sex: Sex,

    @field:NotNull(message = "중성화 여부는 필수 입력값입니다.")
    val isNeutered: Boolean,

    @field:Min(value = 1, message = "나이는 0보다 커야 합니다.")
    val ageMonths: Int,

    @field:Min(value = 1, message = "체중은 0보다 커야 합니다.")
    val weight: Float,

    @field:Min(value = 1, message = "목 둘레는 0보다 커야 합니다.")
    val neckSize: Float,

    @field:Min(value = 1, message = "가슴 둘레는 0보다 커야 합니다.")
    val chestSize: Float,
)
