package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

public class Validator {
	
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		
		if(criteria.getCriteria() == null) {
			return false;
		}
		
		return true;
	}

}