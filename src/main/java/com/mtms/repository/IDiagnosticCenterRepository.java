package com.mtms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mtms.model.DiagnosticCenter;

/*******************************************************************************************************************************

-Description              :     DiagnosticCenter Repository Interface with DiagnosticCenter as Type and Integer as Key

*******************************************************************************************************************************/
public interface IDiagnosticCenterRepository extends CrudRepository<DiagnosticCenter, Integer>{
	
	public List<DiagnosticCenter> findByCenterName(String centerName);


}
