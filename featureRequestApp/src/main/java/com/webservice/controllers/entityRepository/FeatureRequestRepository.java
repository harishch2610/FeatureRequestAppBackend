package com.webservice.controllers.entityRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.entities.FeatureRequest;


@Repository
@Transactional
public interface FeatureRequestRepository extends JpaRepository<FeatureRequest,String> {	
	@Query("SELECT f from FeatureRequest f where f.client =:client ")
    List<FeatureRequest> findAllRequestsByClient(@Param("client") String client);
	
	@Query("SELECT f from FeatureRequest f where f.id =:id ")
    FeatureRequest findAllRequestsById(@Param("id") Long id);
	
	@Modifying
	@Query("update FeatureRequest f set f.clientPriority = :value where f.id = :id")
	void updateClientPriorityById(@Param("id") Long id, @Param("value") int value);
	
	@Modifying
	@Query("delete from FeatureRequest f where f.id = :id")
	void deleteFeatureRequestById(@Param("id") Long id);
}
