//<<<<<<< HEAD
//package et.covid19.rest.dal.repositories;
//
//import et.covid19.rest.swagger.model.ModelHealthFacility;
//import et.covid19.rest.swagger.model.RequestSaveFacility;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface HealthFacilityRepository extends JpaRepository<RequestSaveFacility, Long> {
//}
//=======
package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.HealthFacility;

@Repository
public interface HealthFacilityRepository extends JpaRepository<HealthFacility, Integer> {
}
//>>>>>>> 112155b85c5517eb9d3ee9ba0f6afa2aa4bdebea
