package Registraduria4A.seguridad.Repositorios;
import Registraduria4A.seguridad.Models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RepositorioUsuario extends MongoRepository <Usuario, String>{
    @Query("{'correo':?0}") // SELECT * FROM WHERE CORREO = ?
    public Usuario getUserByEmail(String correo);
}
