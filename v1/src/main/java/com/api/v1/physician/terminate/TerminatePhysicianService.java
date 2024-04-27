package com.api.v1.physician.terminate;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;

public interface TerminatePhysicianService {

	void terminate(@PhysicianLicenseNumber String physicianLicenseNumber);
	
}
