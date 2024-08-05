package fatpet.apiserver.domain.diagnosis.api

import fatpet.apiserver.domain.diagnosis.dto.request.DiagnoseRequest
import fatpet.apiserver.global.common.ApiResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DiagnosisController : DiagnosisApi {
    override fun diagnose(@Valid @RequestBody request: DiagnoseRequest): ApiResponse<Unit> {
        TODO("Not yet implemented")
    }
}
