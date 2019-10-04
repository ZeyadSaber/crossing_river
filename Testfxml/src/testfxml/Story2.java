package testfxml;

import java.util.ArrayList;
import java.util.List;

public class Story2  implements ICrossingStrategy{

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
		if(boatRiders.size() == 1 && !boatRiders.get(0).canSail() || boatRiders.size() == 0)
			return false;
		if(boatRiders.size()==2)
			if(boatRiders.get(0).getWeight()+boatRiders.get(1).getWeight()>100)
				return false;
		return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		List<ICrosser> InitialCrossers = new ArrayList<ICrosser>() ;
		
		Farmer F1 = new Farmer() ;
		F1.setWeight(90.0) ; 
		
		Farmer F2 = new Farmer() ;
		F2.setWeight(80.0) ;
		
		Farmer F3 = new Farmer() ;
		F3.setWeight(60.0) ;
		
		Farmer F4 = new Farmer() ;
		F4.setWeight(40.0) ;
		
		HerbevorusAnimal H = new HerbevorusAnimal();
		
		InitialCrossers.add(F1) ;
		InitialCrossers.add(F2) ;
		InitialCrossers.add(F3) ;
		InitialCrossers.add(F4) ;
		InitialCrossers.add(H) ;	
		
		return InitialCrossers;
	}

	@Override
	public String[] getInstructions() {
		
		String[] instructions = new String[2] ;
		instructions[0]="Story2:\r\n�Four farmers and their animal need to cross a river in a small boat. The weights of the\r\nfarmers are 90 kg, 80 kg,60 kg and 40 kg respectively, and the weight of the animal is\r\n20 kg.�\r\nRules:\r\n1. The boat cannot bear a load heavier than 100 kg.\r\n2. All farmers can raft, while the animal cannot.\r\nHow can they all get to the other side with their animal?";
		
		return instructions;
	}
	

}
