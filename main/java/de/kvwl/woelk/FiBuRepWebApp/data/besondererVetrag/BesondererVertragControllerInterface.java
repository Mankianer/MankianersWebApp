package de.kvwl.woelk.FiBuRepWebApp.data.besondererVetrag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.BesondererVertrag2KT;

@Component
public interface BesondererVertragControllerInterface extends JpaRepository<BesondererVertrag2KT, Long>{
	
	
}
