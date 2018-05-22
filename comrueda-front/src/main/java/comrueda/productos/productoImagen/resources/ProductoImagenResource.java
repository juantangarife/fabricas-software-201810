package comrueda.productos.productoImagen.resources;

import comrueda.common.exceptions.BusinessLogicException;
import comrueda.factories.ProductoImagenEntityFactory;
import comrueda.producto.ejb.ProductoLogic;
import comrueda.producto.entities.ProductoEntity;
import comrueda.productos.productoImagen.dtos.ProductoImagenDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("marketplace/productos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ProductoImagenResource {

    @Inject
    ProductoLogic productoLogic;

    private ProductoImagenEntityFactory productoFactoryEntity;

    private static final Logger LOGGER = Logger.getLogger(ProductoImagenResource.class.getName());

    public ProductoImagenResource() {
        this.productoFactoryEntity = new ProductoImagenEntityFactory();
    }

    @POST
    @Path("agregar")
    public ProductoImagenDTO crearProducto(ProductoImagenDTO producto) throws BusinessLogicException {
        ProductoEntity productoEntity = productoFactoryEntity.getProductoEntity(producto);
        ProductoEntity nuevoProducto = productoLogic.crearProducto(productoEntity);
        return new ProductoImagenDTO(nuevoProducto);
    }

    @GET
    public List<ProductoImagenDTO> getProductosImagen() {
        return listEntity2DTO(productoLogic.listarProductos());
    }

    /*
    @GET
    @Path("{id: \\d+}")
    public ProductoDTO buscar(@PathParam("id") Long id) {
        ProductoEntity entity = productoLogic.buscar(id);
        if (entity != null) {
            return new ProductoDTO(entity);
        }
        return null;
    }
    */

    @PUT
    @Path("{id: \\d+}")
    public ProductoImagenDTO actualizar(@PathParam("id") Long id, ProductoImagenDTO producto) throws BusinessLogicException {
        producto.setId(id);
        ProductoEntity entity = productoLogic.buscar(id);
        if (entity == null) {
            throw new BusinessLogicException("El recurso /productos/" + id + " no existe.");
        }
        return new ProductoImagenDTO(productoLogic.actualizar(productoFactoryEntity.getProductoEntity(producto)));
    }

    /*
    @DELETE
    @Path("{id: \\d+}")
    public void borrar(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un producto con id {0}", id);
        ProductoEntity entity = productoLogic.buscar(id);
        productoLogic.borrar(entity);
    }
    */

    private List<ProductoImagenDTO> listEntity2DTO(List<ProductoEntity> entityList) {
        List<ProductoImagenDTO> list = new ArrayList<ProductoImagenDTO>();
        for (ProductoEntity entity : entityList) {
            list.add(new ProductoImagenDTO(entity));
        }
        return list;
    }
}
