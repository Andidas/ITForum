package service.iService;

import java.util.List;

import net.sf.json.JSONArray;

public interface IJsonService {
	/**
	 * 把java list对象转化成json对象
	 * @param 要转换的对象
	 */
	JSONArray toJSONArray(List Views);
}
