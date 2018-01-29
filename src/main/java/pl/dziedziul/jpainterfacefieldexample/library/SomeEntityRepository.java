package pl.dziedziul.jpainterfacefieldexample.library;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SomeEntityRepository extends JpaRepository<SomeEntity, Long> {
	Optional<SomeEntity> findByType(Type type);
}
