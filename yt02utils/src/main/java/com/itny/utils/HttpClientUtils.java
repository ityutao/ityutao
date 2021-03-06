package com.itny.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqinghua on 17/11/21.
 */
public class HttpClientUtils {

	/**
	 * httpclient执行get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url, Map<String, String> params) {
		// 创建httpclient
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String result = "";
		CloseableHttpResponse httpResponse = null;
		try {
			// 构建uri
			URIBuilder builder = new URIBuilder(url);

			// 构建参数
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					builder.addParameter(param.getKey(), param.getValue());
				}
			}

			URI uri = builder.build();

			// 构建get请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行
			httpResponse = httpClient.execute(httpGet);

			result = EntityUtils.toString(httpResponse.getEntity(), Charset.defaultCharset());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(httpClient, httpResponse);
		}
		return result;
	}

	/**
	 * 执行get请求没有参数
	 *
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		return doGet(url, null);
	}

	/**
	 * 执行post请求
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params) {
		// 创建httpclient
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String result = "";
		CloseableHttpResponse httpResponse = null;
		try {
			// 构建请求
			HttpPost httpPost = new HttpPost(url);

			// 构建参数
			if (params != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : params.entrySet()) {
					paramList.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}

				// 模拟form表单entity
				UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList, Charset.defaultCharset());
				httpPost.setEntity(formEntity);
			}

			// 执行
			httpResponse = httpClient.execute(httpPost);
			result = EntityUtils.toString(httpResponse.getEntity(), Charset.defaultCharset());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(httpClient, httpResponse);
		}
		return result;
	}

	/**
	 * 执行post请求没有参数
	 *
	 * @param url
	 * @return
	 */
	public static String doPost(String url) {
		return doPost(url, null);
	}


	/**
	 * 关闭httpClient和httpResponse
	 *
	 * @param httpClient
	 * @param httpResponse
	 */
	private static void close(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
		if (httpResponse != null) {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (httpClient != null) {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
