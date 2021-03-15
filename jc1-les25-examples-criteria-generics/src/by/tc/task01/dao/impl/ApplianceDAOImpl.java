package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import by.tc.task01.dao.DAOException;
import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.Creator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String path = "resources\\appliances.db";

	@Override
	public <E> Appliance find(Criteria<E> criteria) throws DAOException {
		
		Appliance appliance = null;
		Creator creator = new Creator();
		
		try (BufferedReader buffReader = new BufferedReader(new FileReader(path))) {
			
			String str;
			String nameCriteria = getNameCriteria(criteria);
			
			while(buffReader.ready()) {
				str = buffReader.readLine();
				
				if(str.split(" :" )[0].equals(nameCriteria)) {
					appliance = creator.create(criteria, str.split(" : ")[1], nameCriteria);
				}
			}	
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}
		
		return appliance;
	}
	
	private <E> String getNameCriteria(Criteria<E> criteria) {
		
		Set<E> set = criteria.getCriteria().keySet();
		Iterator<E> iterator = set.iterator();
		
		return iterator.next().getClass().getSimpleName();
	}

}