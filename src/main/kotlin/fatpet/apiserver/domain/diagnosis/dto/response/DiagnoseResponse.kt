package fatpet.apiserver.domain.diagnosis.dto.response

import fatpet.apiserver.domain.diagnosis.application.Bcs

data class DiagnoseResponse(
    val avgWeightLow: Int,
    val avgWeightHigh: Int,
    val bcs: Bcs,
    val der: Float,
    val gptSolution: String,
)
