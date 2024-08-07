package fatpet.apiserver.domain.breed.application

import fatpet.apiserver.domain.breed.dao.BreedRepository
import fatpet.apiserver.domain.breed.domain.Breed
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service

@Service
class BreedReader(
    private val breedRepository: BreedRepository,
) {
    fun findByCode(code: Int): Breed =
        breedRepository.findByCode(code) ?: throw BadRequestException("존재하지 않는 품종입니다.")
}
