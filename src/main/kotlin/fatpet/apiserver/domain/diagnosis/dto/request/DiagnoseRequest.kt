package fatpet.apiserver.domain.diagnosis.dto.request

import jakarta.validation.constraints.Min

data class DiagnoseRequest(
    @field:Min(value = 1, message = "체중은 0보다 커야 합니다.")
    val weight: Float,

    @field:Min(value = 1, message = "목 둘레는 0보다 커야 합니다.")
    val neckSize: Float,

    @field:Min(value = 1, message = "가슴 둘레는 0보다 커야 합니다.")
    val chestSize: Float,
)
