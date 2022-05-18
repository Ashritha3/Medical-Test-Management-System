package com.mtms.controller;

import java.math.BigInteger;
import com.mtms.model.DiagnosticCenter;
import com.mtms.model.DiagnosticCenterList;
import com.mtms.model.DiagnosticTest;
import com.mtms.service.IAppointmentMSService;
import com.mtms.service.IDiagnosticCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*******************************************************************************************************************************

-Description              :     DiagnosticCenterController Class for accessing DiagnosticCenter Management System services

*******************************************************************************************************************************/
@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class DiagnosticCenterController {
	
	@Autowired
	private IDiagnosticCenterService centerService;
	
	@GetMapping("/getallcenters")
	public DiagnosticCenterList getAllCenters()
	{
		 return centerService.getAllCenters();	
	}
	
	@GetMapping("/getcenterbyid/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable Integer centerId)
	{
		return centerService.getCenterById(centerId);
	}
	
	@PostMapping("/addcenter")
	public DiagnosticCenter addCenter(@RequestBody DiagnosticCenter center)
	{
	     	return centerService.addCenter(center); 
	}
	
	@PutMapping("/updatecenter/{centerId}")
	public DiagnosticCenter update(@PathVariable Integer centerId, @RequestBody DiagnosticCenter center) {
		center.setCenterId(centerId);
		return centerService.update(centerId, center);	
		}
	
	@DeleteMapping("/removecenter/center-id/{centerId}")
	public boolean removeCenter(@PathVariable Integer centerId)
	{
		
		return centerService.removeCenter(getCenter(centerId));
	}
	
	@PutMapping("/assigntest/{centerId}")
	public DiagnosticCenter assignTestId(@PathVariable Integer centerId,@RequestBody DiagnosticTest test)
	{
		return centerService.assignTestId(centerId, test);
	}
	
	@DeleteMapping("/center/{centerId}/removetest/{test}")
	public boolean removeTestByName(@PathVariable Integer centerId,@PathVariable String test)
	{
		return centerService.removeTestByName(centerId, test);
	}
	
	
	@DeleteMapping("/removeallcenters")
	public String removeAllCenters() 
	{
		centerService.removeAllCenters();
			return "All Center Removed";
	}
	
	@GetMapping("/getcenter/{centerName}")
	public DiagnosticCenter getCenterByName(@PathVariable String centerName){
		return centerService.getCenterByName(centerName);
	}

}
