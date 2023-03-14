package ad.bedam.demo.utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter
{
    public JsonConverter()
    {

    }

    public String toJson(Object object)
    {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        return gson.toJson(object);
    }


    public String jsonDelete(Boolean deleted)
    {
        return "{'mensaje':' La accíón de eliminar se ha ejecutado', \n'exito':" + deleted+"}";
    }
}
