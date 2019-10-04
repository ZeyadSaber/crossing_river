package testfxml;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Story1 implements ICrossingStrategy{

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
		for(int i=0;i<rightBankCrossers.size();i++) {
			for(int j=i+1;j<rightBankCrossers.size();j++) {
				if(Math.abs(rightBankCrossers.get(i).getEatingRank() - rightBankCrossers.get(j).getEatingRank())== 1) 
					return false;
			}
		}
		for(int i=0;i<leftBankCrossers.size();i++) {
			for(int j=i+1;j<leftBankCrossers.size();j++) {
				if(Math.abs(leftBankCrossers.get(i).getEatingRank() - leftBankCrossers.get(j).getEatingRank())== 1) 
					return false;
			}
		}
		if(!boatRiders.isEmpty()) {
			if(boatRiders.get(0).canSail()|| boatRiders.get(boatRiders.size()-1).canSail())
				return true;
		}
		return false;
		}

	@Override
	public List<ICrosser> getInitialCrossers() {
		List<ICrosser> initialCrossers = new ArrayList<ICrosser>();
		initialCrossers.add(new Farmer());
		initialCrossers.add(new CarnivorusAnimal()); 
		initialCrossers.add(new Plant()); 
		initialCrossers.add(new HerbevorusAnimal());
		return initialCrossers;
		
	}

	@Override
	public String[] getInstructions() {
		String[] instructions = new String[2];  
		instructions[0] = "Story1:\r\n A farmer wants to cross a river and take with him a carnivorous, a herbivorous and\r\nplant.\r\nRules:\r\n1. The farmer is the only one who can sail the boat. He can only take one passenger, in\r\naddition to himself.\r\n2. You can not leave any two crossers on the same bank if they can harm(eat) each other\r\nHow can the farmer get across the river with all the 2 animals and the plant without any losses?";
		return instructions;
	}
	
}
