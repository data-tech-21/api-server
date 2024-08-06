package fatpet.apiserver.domain.diagnosis.api

import fatpet.apiserver.domain.diagnosis.application.DiagnosisService
import fatpet.apiserver.domain.diagnosis.dto.request.DiagnoseRequest
import fatpet.apiserver.domain.diagnosis.dto.response.DiagnoseResponse
import fatpet.apiserver.global.common.ApiResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DiagnosisController(
    private val diagnosisService: DiagnosisService,
) : DiagnosisApi {
    override fun diagnose(@Valid @RequestBody request: DiagnoseRequest): ApiResponse<DiagnoseResponse> =
        ApiResponse.success(diagnosisService.diagnose(request))
}
