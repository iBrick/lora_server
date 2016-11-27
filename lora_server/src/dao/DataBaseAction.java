package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import endnodes.Info;
import endnodes.InfoFSKModEnd;
import endnodes.InfoGateWayStat;
import endnodes.InfoLoraModEnd;
import endnodes.InfoPktError;

public class DataBaseAction {
	static DataBase db;
	public static void SaveData(HashMap<String, Info> infomap){
		Info info; 
		Set set = infomap.keySet(); 
	    for(Iterator itr=set.iterator();itr.hasNext();){ 
			String value =(String) itr.next(); 
			info = (Info)infomap.get(value); 
			if(info instanceof InfoFSKModEnd){
				db = new DataBaseFSKMod();
				db.SaveData(info);
			}
			if(info instanceof InfoLoraModEnd){
				db = new DataBaseLoRaMod();
				db.SaveData(info);
			}
			if(info instanceof InfoGateWayStat){
				db = new DataBaseGatewayStat();
				db.SaveData(info);
			}	
			if(info instanceof InfoPktError){
				db = new DataBasePktError();
				db.SaveData(info);
			}

	    } 
	}
	
	public static void Query(String q_str){
		
	}
	
}
