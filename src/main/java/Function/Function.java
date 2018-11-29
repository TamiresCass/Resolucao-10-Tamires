package Function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import lombok.Data;

public class Function 
{
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    @FunctionName ("createfuncionario")
    public Funcionario create (
        @HttpTrigger (name = "createfuncionariorest", methods = {HttpMethod.POST}, route = "funcionario", authLevel = AuthorizationLevel.ANONYMOUS)
        
        Funcionario t) {
                    
        t.setId(777);
        t.setNome("Tamires");
        t.setIda(90);
        t.setSal(9876);

        funcionarios.add(t);

        return t;
    }
    
    @FunctionName ("listfuncionario")
    public ArrayList<Funcionario> list(
        @HttpTrigger (
            name = "listfuncionariorest",
            methods = {HttpMethod.GET},
            route = "funcionario", 
            authLevel = AuthorizationLevel.ANONYMOUS
           
         )
        Funcionario t)
        {

        return funcionarios;
        }
    

    @FunctionName ("updateemployee")
    public Funcionario update (
        @HttpTrigger (
            name = "updatefuncionariorest",
            methods = {HttpMethod.PUT},
            route = "funcionario", 
            authLevel = AuthorizationLevel.ANONYMOUS
          
        ) 
        Funcionario t) 
        {
        
        t.setNome(t.getNome() + " - updated!");

        return t;
    }

    @FunctionName ("deletefuncionario")
    public Funcionario delete (
        @HttpTrigger (
            name = "deletefuncionariorest",
            methods = {HttpMethod.DELETE},
            route = "employee", 
            authLevel = AuthorizationLevel.ANONYMOUS
           
        )
        Funcionario t) 
        {
            t.remove(t);    
            
            return t;
        }    
}

@Data
class Funcionario
{
    private long id;
    private String nome;
    private int ida;
    private double sal;
    public Funcionario()
    {

    }

    public Funcionario(long id, String name, int ida, double sal)
    {
        this.id = id;
        this.nome = nome;
        this.ida = ida;
        this.sal = sal;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getIda() 
    {
        return ida;
    }

    public void setIda(int Ida) 
    {
        this.ida = ida;
    }

    public double getSal() 
    {
        return sal;
    }

    public void setSal(double sal) 
    {
        this.sal = sal;
    }
}