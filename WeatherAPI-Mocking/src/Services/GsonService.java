package Services;

import com.google.gson.Gson;

import Contracts.IJsonService;

public class GsonService implements IJsonService {
    private static Gson gson = new Gson();

    @Override
    public <T> T fromJson(String jsonString, Class<T> classOfT) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toJson(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

}
