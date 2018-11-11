/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Alunos
 * @param <Object>
 */
public interface Lista<Object> {
    
    public abstract void adicionar(Object o);
    
    public abstract void adicionar(Object o, Integer idx);
    
    public abstract void substituir(Object o, Integer idx);
    
    public abstract Object buscar(Object o);
    
    public abstract Object buscar(Integer idx);
    
    public abstract Boolean remover(Object o);
    
    public abstract Boolean remover(Integer idx);
    
    public abstract Integer tamanho();
    
    @Override
    public abstract String toString();
    
    public abstract Boolean existe(Object o);
    
    public abstract String toStringInverse();
}
