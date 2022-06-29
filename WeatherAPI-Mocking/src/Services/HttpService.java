package Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import Contracts.IHttpService;

public class HttpService implements IHttpService
{
	public HttpClient client;
	public HttpRequest request;
	public HttpResponse<String> response;
	public HttpResponse<String> response2;

	public String Http (String x)
    {
    	client =  HttpClient.newHttpClient();
   	 	request = HttpRequest.newBuilder().uri(URI.create(x)).build();
   	 	try {
			response =  client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.body();
    }
}
