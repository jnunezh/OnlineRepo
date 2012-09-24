

package tarea_ingsoft;

interface Comparer<T>
{
   public int compareTo(T a,T b);
}
//------------------------
class NameComparer implements Comparer<Person>
{
   @Override
   public int compareTo(Person a,Person b)
   {
       return a.nombre.compareTo(b.nombre);
   }
}
class DniComparer implements Comparer<Person>
{
   @Override
   public int compareTo(Person a,Person b)
   {
       return a.dni.compareTo(b.dni);
   }
   @Override
   public String toString()
   {
      return "Soy DNI Comparer";
   }
}
class AgeComparer implements Comparer<Person>
{
   @Override
   public int compareTo(Person a,Person b)
   {
       return Integer.signum(a.edad - b.edad);
   }
}
//------------------------

class Person
{
    public String nombre;
    public int edad;
    public String dni;
    public Person(String nom,int e,String dn){
    nombre = nom;
    edad = e;
    dni = dn;
    }
    @Override
    public String toString()
    {
        return "nombre:"  + nombre + ";dni:" + dni + ";edad:" + edad;
    }
}



class BubbleSorter
{

    public static <T,U extends Comparer<T> > void sortAsc(T[] array,U comp)
    {
        sort(array,comp,-1);
    }
    public static <T,U extends Comparer<T> > void sortDesc(T[] array,U comp)
    {
        sort(array,comp,1);
    }
    protected static <T,U extends Comparer<T> > void sort(T[] array,U comparer,int ord)
    {
       T temp;
       for (int i = 1; i < array.length; i++)
        {
            for (int x = array.length - 1; x >=i ; x--)
            {
                if (comparer.compareTo(array[x],array[x-1])*ord > 0)
                {
                    temp = array[x];
                    array[x] = array[x - 1];
                    array[x-1] = temp;
                }
            }
        }
    }
}

public class Main {

    
    public static void main(String[] args) {

        Person[] pers = {new Person("Juan",17,"9413289"),new Person("Ana",37,"7473289"),
        new Person("Roberto",11,"5483289")};
        
        BubbleSorter.sortDesc(pers,new DniComparer());
        for(Person p:pers)
        {
          System.out.println(p);
        }
        System.out.println("-----------------------------------------");
        BubbleSorter.sortAsc(pers,new AgeComparer());
        for(Person p:pers)
        {
          System.out.println(p);
        }
    }
        

}
