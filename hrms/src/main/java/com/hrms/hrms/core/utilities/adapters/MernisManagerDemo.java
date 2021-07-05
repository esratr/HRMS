package com.hrms.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class MernisManagerDemo implements MernisServiceDemo {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
	
		if(candidate.getNationalIdentity().length()!=11) {
			System.out.println("Gerçek kişi değildir.");
			return false;
			
		}
		System.out.println("Geçerli TC Kimlik Numarası.");
		return true;
	}

}
