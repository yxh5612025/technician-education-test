package com.zzhy.common.utils.lianlumsg;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class SmsRequest {

	/**
	 * 请求，只请求一次，不做重试
	 * 
	 * @param url
	 * @param connectTimeoutMs
	 * @param readTimeoutMs
	 * @return
	 * @throws Exception
	 */
	public static String requestOnce(final String url, String appId, String data, int connectTimeoutMs, int readTimeoutMs) throws Exception {
		BasicHttpClientConnectionManager connManager;
		connManager = new BasicHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build(), null, null, null);

		HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connManager).build();
		HttpPost httpPost = new HttpPost(url);
		
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs).setConnectTimeout(connectTimeoutMs).build();
		httpPost.setConfig(requestConfig);

		StringEntity postEntity = new StringEntity(data, "UTF-8");
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("Authorization", appId);
		httpPost.setEntity(postEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity httpEntity = httpResponse.getEntity();
		return EntityUtils.toString(httpEntity, "UTF-8");
	}
}
