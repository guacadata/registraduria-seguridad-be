package Registraduria4A.seguridad.Repositorios;
import Registraduria4A.seguridad.Models.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRol extends MongoRepository <Rol, String> {
}
