package Services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import Contracts.IJsonService;

public class GsonService implements IJsonService 
{
    private static Gson gson = new Gson();
    
    @Override
    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException 
    {
        return gson.fromJson(json, classOfT);
      }

    @Override
    public String toJson(Object object) 
    {
    	return gson.toJson(object);
    }

}
