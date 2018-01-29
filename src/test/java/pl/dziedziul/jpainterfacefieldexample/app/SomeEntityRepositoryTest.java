package pl.dziedziul.jpainterfacefieldexample.app;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pl.dziedziul.jpainterfacefieldexample.library.SomeEntity;
import pl.dziedziul.jpainterfacefieldexample.library.SomeEntityRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SomeEntityRepositoryTest {

	@Autowired
	private SomeEntityRepository sut;
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void shouldFindByMigrationId() throws Exception {
		//given
		testEntityManager.persistAndFlush(new SomeEntity(SpecificEntityType.A));
		testEntityManager.clear();
		//when
		Optional<SomeEntity> migration = sut.findByType(SpecificEntityType.A);
		//then
		assertTrue(migration.isPresent());
		assertThat(migration.get().getType(), is(SpecificEntityType.A));
	}

	@Test
	public void shouldNotFindByMigrationId() throws Exception {
		//given
		testEntityManager.persistAndFlush(new SomeEntity(SpecificEntityType.A));
		testEntityManager.clear();
		//when
		Optional<SomeEntity> migration = sut.findByType(SpecificEntityType.B);
		//then
		assertFalse(migration.isPresent());
	}
}