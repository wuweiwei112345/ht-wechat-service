package com.wechat.basiccomponent;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口与实现类之间的骨架实现类方便实现类的开发
 * @auther: wuwei
 * @date: 2019/3/22 16:33
 */
public abstract class WeChatAbstractService implements WeChatService {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Map<String,String> invoke(Map<String,String> paramMap){
		//参数验证
		if(paramMap == null){
			return null;
		}
		//生成请求参数
		Map<String,Object> requestParamMap = this.createRequestParam(paramMap);
		//请求并获取响应数据
		String responseData = this.doRequest(requestParamMap);
		//解析返回结果 并获取到指定参数数据
		Map<String,String> responseDataMap = this.resolveReponseData(responseData);
		//返回值
		return responseDataMap;
	}

	@Override
	public String invokeGetByStatus(Map<String, String> paramMap,String statusKey){
		//参数验证
		if(paramMap == null){
			return null;
		}
		if(statusKey == null || "".equals(statusKey)){
			return null;
		}
		//生成请求参数
		Map<String,Object> requestParamMap = this.createRequestParam(paramMap);
		//请求并获取响应数据
		String responseData = this.doRequest(requestParamMap);
		//解析返回结果 并获取到指定参数数据
		Map<String,String> responseDataMap = this.resolveReponseData(responseData);
		//获取预期key值
		String statusVal = responseDataMap.get(statusKey);
		//返回值
		return statusVal;
	}

	/**
	 * 创建请求需要的参数（包括请求参数、请求地址）
	 * 功能描述:创建请求需要的参数（包括请求参数、请求地址）
	 * @param: paramMap 请求参数 必选
	 * @return: 返回的Map数据 （包含请求参数、请求地址）
	 * @auther: wuwei
	 * @date: 2019/3/22 16:50
	 */
	public abstract Map<String,Object> createRequestParam(Map<String, String> requestParamMap);

	/**
	 * 执行请求动作
	 * 功能描述:执行请求动作
	 * @param: paramMap 请求数据
	 * @return: 返回响应数据
	 * @auther: wuwei
	 * @date: 2019/3/22 17:09
	 */
	public String doRequest(Map<String,Object> paramMap){
		//参数验证
		if(paramMap == null){
			return null;
		}
		if(paramMap.get("method") == null || "".equals(paramMap.get("method"))){
			return null;
		}
		if(paramMap.get("data") == null || "".equals(paramMap.get("data"))){
			return null;
		}
		//判断请求方式
		String responseData = null;
		if("POST".equals(paramMap.get("method"))){
			//用POST方式请求
			responseData = null;
		}else if("GET".equals(paramMap.get("method"))){
			//用GET方式请求
			responseData = null;
		}
		return responseData;
	}

	/**
	 * 解析返回结果 并获取到指定参数数据
	 * 功能描述:解析返回结果 并获取到指定参数数据
	 * @param: responseData 响应数据 必选
	 * @return: 返回解析后的数据以Map形式
	 * @auther: wuwei
	 * @date: 2019/3/22 16:50
	 */
	public Map<String,String> resolveReponseData(String responseData){
		//编写解析逻辑
		return null;
	}

}
