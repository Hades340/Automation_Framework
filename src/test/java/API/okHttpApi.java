package API;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import com.google.gson.Gson;

import okhttp3.*;
import utils.contains;
import utils.fileUtils;

public class okHttpApi {
	private static final OkHttpClient client = new OkHttpClient();
	private static final Gson gson = new Gson();

	public static boolean insert(HashMap<String, String> data, String url) {
		boolean responseCheck = false;
		try {
			String jsonTestSuite = gson.toJson(data);
			System.out.println(jsonTestSuite);
			RequestBody body = RequestBody.create(contains.JSON, jsonTestSuite);
			Request request = new Request.Builder().url(url).post(body).build();
			Response response = client.newCall(request).execute();
			if (response.body()!=null) {
				System.out.println("reponse is " + response.body().string());
			}
			if (response.isSuccessful()) {
				responseCheck = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return responseCheck;
	}

	public static String insertImg(String filePath, String url, MediaType mediaType) {
		String pathInServer = "";
		try {
			File fileUpload = fileUtils.getFileFromPath(filePath);
			String[] fileName = filePath.split("\\/");
			System.out.println(fileName[fileName.length-1]);
			assert fileUpload != null;
			if (fileUpload.exists()) {
				RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("fileName",fileName[fileName.length-1], RequestBody.create(mediaType, fileUpload)).build();

				Request request = new Request.Builder().url(url).post(requestBody).build();

				Response response = client.newCall(request).execute();
				if (response.isSuccessful()) {
					if (response.body() !=null) {
						pathInServer = response.body().string();
					}
				}
			}
			System.out.println(pathInServer);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return pathInServer;
	}
}
