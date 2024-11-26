package online.jadg13.registro_docente.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
public class Docente {

    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @Column(length = 50)
    @Required(message = "El nombre del docente es obligatorio")
    private String nombres;

    @Column(length = 50)
    @Required(message = "El apellido del docente es obligatorio")
    private String apellidos;

    @Column(length = 150)
    @Email(message = "El correo no es válido")
    private String correo;

    @Column(length = 20)
    private String telefono;

    @Column(length = 120)
    @Required(message = "El título del docente es obligatorio")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList
    private Carrera carrera;
}
