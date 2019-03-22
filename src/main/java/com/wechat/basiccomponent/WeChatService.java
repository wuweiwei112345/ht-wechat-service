package com.wechat.basiccomponent;

import java.util.Map;

/**
 * 微信官方接口
 * @auther: wuwei
 * @date: 2019/3/22 16:33
 */
public interface WeChatService {

	/**
	 * 调用接口实现方法
	 */
	public Map<String,String> invoke(Map<String, String> paramMap);

	/**
	 * 调用接口实现方法（根据状态key直接返回对应的值）
	 */
	public String invokeGetByStatus(Map<String, String> paramMap,String statusKey);
	
}
