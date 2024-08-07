package fatpet.apiserver.domain.diagnosis.application

import fatpet.apiserver.domain.breed.application.BreedReader
import fatpet.apiserver.domain.breed.domain.Breed
import fatpet.apiserver.domain.breed.domain.Sex
import fatpet.apiserver.domain.diagnosis.dto.request.DiagnoseRequest
import fatpet.apiserver.domain.diagnosis.dto.response.DiagnoseResponse
import org.springframework.stereotype.Service

@Service
class DiagnosisService(
    private val breedReader: BreedReader,
) {
    fun diagnose(request: DiagnoseRequest): DiagnoseResponse {
        val (breedCode, sex, isNeutered, ageMonths, weight, neckSize, chestSize) = request

        val breed = breedReader.findByCode(breedCode)

        val sexCode = getSexCode(sex, isNeutered)

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

    private fun getSexCode(sex: Sex, isNeutered: Boolean): Int =
        if (sex == Sex.MALE) {
            if (isNeutered) 0
            else 2
        } else {
            if (isNeutered) 3
            else 1
        }

    private fun getBcs(
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

    private fun getDer(isNeutered: Boolean, ageMonths: Int, weight: Float, bcs: Bcs): Float {
        val isObesity = bcs == Bcs.OVER

        val coefficient = when {
            ageMonths < 4 -> 3F
            ageMonths < 18 -> 2F
            ageMonths < 84 && isObesity -> 1.2F
            ageMonths < 84 && isNeutered -> 1.6F
            ageMonths < 84 -> 1.8F
            isNeutered -> 1.2F
            else -> 1.4F
        }

        val rer = getRer(weight)

        return rer * coefficient
    }

    private fun getGptSolution(
        breed: Breed,
        isNeutered: Boolean,
        ageMonths: Int,
        weight: Float,
        bcs: Bcs,
        der: Float,
    ): List<String> {
        TODO()
    }
}
