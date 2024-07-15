package currere.apiserver.domain.member.dto.response

import io.swagger.v3.oas.annotations.media.Schema

data class SignInResponse(
    @Schema(example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwIiwicm9sZSI6IkVYQU1QTEUiLCJpYXQiOj3MY...")
    val accessToken: String,

    @Schema(example = "jEsImV4cCI6MTcxNTc4ODU2MX0.VkMATOtPMQcVf9gM9NpM50EQab61eexWnzQBOaN_NVY...")
    val refreshToken: String,
)
