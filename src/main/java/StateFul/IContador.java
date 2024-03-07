package StateFul;

import javax.ejb.Remote;

@Remote
public interface IContador {
    public void agregarItem();
    public void borrarItem();

    public int contarItem();

    public void borrarTodo();

    public String test();
}
