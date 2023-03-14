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
@Document(collection = "Usuarios")
public class Usuario
{
    @Id
    @Expose
    private Long idUsuario;
    @Expose
    private String nickName;
    @Expose
    private String nombre;
    @Expose
    private String apellidos;
    @Expose
    private Date fechaNac;

    @DBRef
    private List<Plan> planes = new ArrayList<>();
}
