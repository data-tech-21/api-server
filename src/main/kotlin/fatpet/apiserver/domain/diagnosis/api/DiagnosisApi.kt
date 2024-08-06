package fatpet.apiserver.domain.diagnosis.api

import fatpet.apiserver.domain.diagnosis.dto.request.DiagnoseRequest
import fatpet.apiserver.domain.diagnosis.dto.response.DiagnoseResponse
import fatpet.apiserver.global.common.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Tag(name = "Diagnosis API")
@RequestMapping("/api/diagnoses")
interface DiagnosisApi {
    @Operation(summary = "비만도 진단")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun diagnose(request: DiagnoseRequest): ApiResponse<DiagnoseResponse>
}
