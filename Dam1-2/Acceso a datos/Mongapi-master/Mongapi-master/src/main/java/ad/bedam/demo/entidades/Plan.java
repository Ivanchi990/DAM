package ad.bedam.demo.entidades;

import com.google.gson.annotations.Expose;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Planes")
public class Plan
{
    @Id
    @Expose
    private Long idPlan;
    @Expose
    private String nombre;
    @Expose
    private String descripcion;
    @Expose
    private Date fecha;

    @DBRef
    private List<Usuario> usuarios = new ArrayList<>();
}
