package shop.dziupla.spring.login.controllers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.login.payload.response.PhotoDTO;
import shop.dziupla.spring.login.security.services.PhotoService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    @Autowired
    PhotoService service;

    @GetMapping("")
    public ResponseEntity<List<PhotoDTO>> getAllPhotos() {
        return new ResponseEntity<>(service.getAllPhotos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> getPhotoById(@PathVariable("id") Long id) {
        try{
            return id==null?
                    new ResponseEntity<>(HttpStatus.BAD_REQUEST):
                    new ResponseEntity<>(service.getPhotoById(id), HttpStatus.OK);
        }
        catch (EntityNotFoundException enfe){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<PhotoDTO> createPhoto(@RequestBody PhotoDTO photoDTO) {
        try{
            return new ResponseEntity<>(service.addPhoto(photoDTO), HttpStatus.OK);
        }
        catch (IllegalArgumentException | NullPointerException iae){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole(" + ERole(0) + ")")
    public ResponseEntity<HttpStatus> deletePhotoById (@PathVariable("id") Long id){
        try{
            service.deletePhotoById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(NullPointerException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<PhotoDTO> updatePhoto(@RequestBody PhotoDTO photoDTO) {
        try{
            var result = service.updatePhoto(photoDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(NullPointerException | IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(EntityExistsException ex){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
