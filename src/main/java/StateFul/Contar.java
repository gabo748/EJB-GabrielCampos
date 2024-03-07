package StateFul;

import javax.ejb.Stateful;

@Stateful
public class Contar implements IContador {
    private int item;

    @Override
    public void agregarItem() {
        item++;
    }

    @Override
    public void borrarItem() {
        System.out.println("hi");
    }

    @Override
    public int contarItem() {
        return 2;
    }

    @Override
    public void borrarTodo() {
        System.out.println("hi");
    }

    @Override
    public String test() {
        return "SE AGREGO";
    }
}

