package Registraduria4A.seguridad.Controllers;
import Registraduria4A.seguridad.Models.Permiso;
import Registraduria4A.seguridad.Repositorios.RepositorioPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos")

public class PermisoController {
    @Autowired
    private RepositorioPermiso myRepositorioPermiso;

    @GetMapping("")
    public List <Permiso> mostrarPermisos (){
        return this.myRepositorioPermiso.findAll();
    }
    @GetMapping("{id}")
    public Permiso mostrarPermiso (@PathVariable String id) {
        Permiso permiso1 = this.myRepositorioPermiso.findById(id).orElse(null);
        return permiso1;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso crear (@RequestBody Permiso infoPermiso) {
        return this.myRepositorioPermiso.save(infoPermiso);
    }
    @PutMapping("{id}")
    public Permiso actualizar (@PathVariable String id, @RequestBody Permiso infoPermiso) {
        Permiso permiso1 = this.myRepositorioPermiso.findById(id).orElse(null);
        if (permiso1 != null) {
            permiso1.setUrl(infoPermiso.getUrl());
            permiso1.setMetodo(infoPermiso.getMetodo());
            return this.myRepositorioPermiso.save(permiso1);
        }
        else {
            return null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar (@PathVariable String id) {
        Permiso permiso1 = this.myRepositorioPermiso.findById(id).orElse(null);
        if (permiso1 != null) {
            this.myRepositorioPermiso.delete(permiso1);
        }
    }
}
