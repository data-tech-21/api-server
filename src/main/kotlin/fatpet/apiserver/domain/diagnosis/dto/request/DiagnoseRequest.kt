package fatpet.apiserver.domain.diagnosis.dto.request

data class DiagnoseRequest(
    val weight: Float = 0F,

    val neckSize: Float = 0F,

    val chestSize: Float = 0F,
)
