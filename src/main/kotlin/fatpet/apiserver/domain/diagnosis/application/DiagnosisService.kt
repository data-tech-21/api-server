package fatpet.apiserver.domain.diagnosis.application

import fatpet.apiserver.domain.breed.dao.BreedRepository
import fatpet.apiserver.domain.breed.domain.Breed
import fatpet.apiserver.domain.breed.domain.Sex
import fatpet.apiserver.domain.diagnosis.dto.request.DiagnoseRequest
import fatpet.apiserver.domain.diagnosis.dto.response.DiagnoseResponse
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service

@Service
class DiagnosisService(
    private val breedRepository: BreedRepository,
) {
    fun diagnose(request: DiagnoseRequest): DiagnoseResponse {
        val (breedCode, sex, isNeutered, ageMonths, weight, neckSize, chestSize) = request

        val sexCode = if (sex == Sex.MALE) {
            if (isNeutered) 0
            else 2
        } else {
            if (isNeutered) 3
            else 1
        }

        val breed = breedRepository.findByCode(breedCode) ?: throw BadRequestException()

        val bcs = getBcs(breed, sexCode, ageMonths, weight, neckSize, chestSize)

        val der = getDer(isNeutered, ageMonths, weight, bcs)

        val gptSolution = getGptSolution(breed, isNeutered, ageMonths, weight, bcs, der)

        return DiagnoseResponse(
            avgWeightLow = breed.avgWeightLow,
            avgWeightHigh = breed.avgWeightHigh,
            bcs = bcs,
            der = der,
            gptSolution = gptSolution
        )
    }

    fun getBcs(
        breed: Breed,
        sexCode: Int,
        ageMonths: Int,
        weight: Float,
        neckSize: Float,
        chestSize: Float,
    ): Bcs {
        TODO()
    }

    private fun getRer(weight: Float): Float = weight * 30 + 70

    fun getDer(isNeutered: Boolean, ageMonths: Int, weight: Float, bcs: Bcs): Float {
        val rer = getRer(weight)

        if (ageMonths < 4) {
            return rer * 3F
        }

        if (ageMonths < 18) {
            return rer * 2F
        }

        if (bcs == Bcs.OVER) {
            return rer * 1.2F
        }

        return if (isNeutered) {
            rer * 1.6F
        } else {
            rer * 1.8F
        }
    }

    fun getGptSolution(
        breed: Breed,
        isNeutered: Boolean,
        ageMonths: Int,
        weight: Float,
        bcs: Bcs,
        der: Float,
    ): String {
        TODO()
    }
}
