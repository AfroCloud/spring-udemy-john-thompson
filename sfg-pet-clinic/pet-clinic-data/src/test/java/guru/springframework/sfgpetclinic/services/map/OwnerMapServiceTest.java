package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;

	final Long ownerId = 1L;

	final String lastName = "Smith";

	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService ( new PetTypeMapService ( ), new PetMapService ( ) );
		ownerMapService.save ( Owner.builder ( ).id ( ownerId ).lastName ( lastName ).build ( ) );
	}

	@Test
	void findAll() {
		Set<Owner> ownerSet = ownerMapService.findAll ( );
		assertEquals ( 1, ownerSet.size ( ) );
	}

	@Test
	void findById() {
		Owner owner = ownerMapService.findById ( ownerId );
		assertEquals ( ownerId, owner.getId ( ) );
	}

	@Test
	void deleteById() {
		ownerMapService.deleteById ( ownerId );
		assertEquals ( 0, ownerMapService.findAll ( ).size ( ) );
	}

	@Test
	void delete() {
		ownerMapService.delete ( ownerMapService.findById ( ownerId ) );
		assertEquals ( 0, ownerMapService.findAll ( ).size ( ) );
	}

	@Test
	void save() {
		Long id = 2L;
		Owner owner = Owner.builder ( ).id ( id ).build ( );
		Owner savedOwner = ownerMapService.save ( owner );
		assertEquals ( id, savedOwner.getId ( ) );
	}

	@Test
	void findByLastName() {
		Owner smith = ownerMapService.findByLastName ( lastName );
		assertNotNull ( smith );
		assertEquals ( ownerId, smith.getId ( ) );
	}

	@Test
	void findByLastNameNotFound() {
		Owner foo = ownerMapService.findByLastName ( "foo" );
		assertNull ( foo );
	}

	@Test
	void saveNoId() {
		Owner savedOwner = ownerMapService.save ( Owner.builder ( ).build ( ) );
		assertNotNull ( savedOwner );
		assertNotNull ( savedOwner.getId ( ) );
	}

}
