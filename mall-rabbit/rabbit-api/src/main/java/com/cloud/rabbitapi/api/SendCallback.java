package com.cloud.rabbitapi.api;

/**
 * 	$SendCallback 回调函数处理
 * @author 2u
 *
 */
public interface SendCallback {

	void onSuccess();
	
	void onFailure();
	
}
