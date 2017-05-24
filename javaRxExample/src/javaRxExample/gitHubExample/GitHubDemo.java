package javaRxExample.gitHubExample;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GitHubDemo {

	public static void main(String[] args) {

		JSONArray obj = null;
		try {
			obj = readJsonFromUrl("https://api.github.com/users/namitsharma99/repos?per_page=1000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Following is the straight forward depiction of the Json Array obtained from the URL
		Observable<JSONArray> gitObservable = Observable.just(obj);
		Consumer<JSONArray> consumer = new Consumer<JSONArray>() {
			@Override
			public void accept(JSONArray obj) throws Exception {
				System.out.println("From consumer JSONArray is : \n"
						+ obj.toString());
			}
		};
		gitObservable.subscribe(consumer);

		System.out
				.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// Following is the mapping and filtering of the Json Array obtained from the URL
		Observable<Object> observable1 = gitObservable
				.flatMap(jsonObjects -> gitObservable);

		Observable<Object> observable2 = observable1
				.filter(json -> ((JSONArray) json).get(0) != null)
				.map(json -> ((JSONObject) ((JSONArray) json).get(0)).get("full_name"));

		Consumer<Object> consumer2 = new Consumer<Object>() {
			@Override
			public void accept(Object obj) throws Exception {

				/*
				 * this is another way to do the filtering, but filtering at the
				 * consumer end is not encouraged...
				 */
				// JSONArray jsonArray = (JSONArray) obj;
				// JSONObject jsonObject = (JSONObject) jsonArray.get(0);
				// System.out.println(jsonObject.get("name"));

				System.out.println(obj);
			}
		};
		observable2.subscribe(consumer2);
	}

	/**
	 * method to read a json from the url directly
	 * */
	public static JSONArray readJsonFromUrl(String url) throws Exception {
		URL urlObject = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlObject
				.openConnection();
		connection.connect();

		JSONParser jsonParser = new JSONParser();
		InputStreamReader inputStream = new InputStreamReader(
				(InputStream) connection.getContent());
		return (JSONArray) jsonParser.parse(inputStream);
	}
}
