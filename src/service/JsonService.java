package service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.iService.IJsonService;

public class JsonService implements IJsonService {
	@Override
	public JSONArray toJSONArray(List Views){
		JSONArray ja = new JSONArray();
		
		for(int i =0;i<Views.size();i++){
			JSONObject jo = JSONObject.fromObject(Views.get(i));
			ja.add(jo);
		}
		return ja;
	}
}
