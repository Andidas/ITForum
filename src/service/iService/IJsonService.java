package service.iService;

import java.util.List;

import net.sf.json.JSONArray;

public interface IJsonService {
	/**
	 * ��java list����ת����json����
	 * @param Ҫת���Ķ���
	 */
	JSONArray toJSONArray(List Views);
}
