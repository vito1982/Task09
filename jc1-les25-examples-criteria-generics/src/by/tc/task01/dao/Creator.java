package by.tc.task01.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class Creator {
	
	private Appliance appliance;
	
	public <E> Appliance create(Criteria<E> criteria, String data, String nameCriteria) {
		
		List<String> list = new ArrayList<>();
		
		boolean exist = false;
		
		for(Map.Entry<E, Object> s : criteria.getCriteria().entrySet()) {
			list.add(s.getKey() + "=" + s.getValue());
		}
		
		for(String s : list) {
			if(data.contains(s)) {
				exist = true;
			} else {
				exist = false;
				break;
			}
		}
		
		if(exist) {
			createAppliance(data, nameCriteria);
		}
		
		return appliance;
	}
	
	
	private void createAppliance(String data, String name) {
		String[] dataArray = data.split(", ");
		
		switch(name) {
			case ("Laptop") :
				appliance = new Laptop(Double.parseDouble(dataArray[0].split("=")[1]),
									dataArray[1].split("=")[1],
									Integer.parseInt(dataArray[2].split("=")[1]),
									Integer.parseInt(dataArray[3].split("=")[1]),
									Double.parseDouble(dataArray[4].split("=")[1]),
									Integer.parseInt(dataArray[5].split("=")[1]));
				break;
			case ("Oven") :
				appliance = new Oven(Integer.parseInt(dataArray[0].split("=")[1]),
									Double.parseDouble(dataArray[1].split("=")[1]),
									Integer.parseInt(dataArray[2].split("=")[1]),
									Double.parseDouble(dataArray[3].split("=")[1]),
									Double.parseDouble(dataArray[4].split("=")[1]),
									Double.parseDouble(dataArray[5].split("=")[1]));
				break;
			case ("Refrigerator") :
				appliance = new Refrigerator(Integer.parseInt(dataArray[0].split("=")[1]),
									Double.parseDouble(dataArray[1].split("=")[1]),
									Integer.parseInt(dataArray[2].split("=")[1]),
									Integer.parseInt(dataArray[3].split("=")[1]),
									Double.parseDouble(dataArray[4].split("=")[1]),
									Double.parseDouble(dataArray[5].split("=")[1])); 
				break;
			case ("Speakers") :
				appliance = new Speakers(Integer.parseInt(dataArray[0].split("=")[1]),
									Integer.parseInt(dataArray[1].split("=")[1]),
									dataArray[2].split("=")[1],
									Integer.parseInt(dataArray[3].split("=")[1]));
				break;
			case ("TabletPC") :
				appliance = new TabletPC(Integer.parseInt(dataArray[0].split("=")[1]),
									Integer.parseInt(dataArray[1].split("=")[1]),
									Integer.parseInt(dataArray[2].split("=")[1]),
									Integer.parseInt(dataArray[3].split("=")[1]),
									dataArray[4].split("=")[1]);
				break;
			case ("VacuumCleaner") :
				appliance = new VacuumCleaner(Integer.parseInt(dataArray[0].split("=")[1]),
									dataArray[1].split("=")[1],
									dataArray[2].split("=")[1],
									dataArray[3].split("=")[1],
									Integer.parseInt(dataArray[4].split("=")[1]),
									Integer.parseInt(dataArray[5].split("=")[1]));
				break;
			default:
				appliance = null;
				break;
		}
	}
}
