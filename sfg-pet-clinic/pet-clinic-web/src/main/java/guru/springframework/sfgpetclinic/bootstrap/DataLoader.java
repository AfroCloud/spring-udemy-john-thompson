package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader() {
		ownerService = new OwnerServiceMap ( );
		vetService = new VetServiceMap ( );
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner ( );
		owner1.setId ( 1L );
		owner1.setFirstName ( "Padmanabha" );
		owner1.setLastName ( "Das" );
		ownerService.save ( owner1 );

		Owner owner2 = new Owner ( );
		owner2.setId ( 2L );
		owner2.setFirstName ( "Prosenjit" );
		owner2.setLastName ( "Das" );
		ownerService.save ( owner2 );

		System.out.println ( "Loaded owners..." );

		Vet vet1 = new Vet ( );
		vet1.setId ( 1L );
		vet1.setFirstName ( "Sam" );
		vet1.setLastName ( "Axe" );
		vetService.save ( vet1 );

		Vet vet2 = new Vet ( );
		vet2.setId ( 2L );
		vet2.setFirstName ( "Jessie" );
		vet2.setLastName ( "Porter" );
		vetService.save ( vet2 );

		System.out.println ( "Loaded vets..." );
	}
}
