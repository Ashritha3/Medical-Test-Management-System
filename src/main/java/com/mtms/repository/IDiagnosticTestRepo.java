package com.mtms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mtms.model.DiagnosticTest;

/*******************************************************************************************************************************

-Description              :     DiagnosticTest Repository Interface with DiagnosticTest as Type and Integer as Key

*******************************************************************************************************************************/

public interface IDiagnosticTestRepo extends CrudRepository<DiagnosticTest, Integer>{
	
	public List<DiagnosticTest> findBytestName(String testName);

}
