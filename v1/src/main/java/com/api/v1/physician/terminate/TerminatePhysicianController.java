package com.api.v1.physician.terminate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.constants.HttpStatusCodes;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class TerminatePhysicianController {
	
	private final TerminatePhysicianServiceImpl service;
	
	@PatchMapping("{physicanLicenseNumber}")
	@Transactional
	public ResponseEntity<Void> terminate(@PathVariable @NotNull @Size(min = 7, max = 7) String physicanLicenseNumber) {
		service.terminate(physicanLicenseNumber);
		return HttpStatusCodes.NO_CONTENT_204;
	}

}
