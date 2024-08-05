package fatpet.apiserver.domain.breed.dao

import fatpet.apiserver.domain.breed.domain.Breed
import org.springframework.data.jpa.repository.JpaRepository

interface BreedRepository : JpaRepository<Breed, Long>
