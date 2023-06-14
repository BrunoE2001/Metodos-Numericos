import java.util.ArrayList;

public class ReglaFalsa{

    ArrayList<String> iter = new ArrayList<>();
    public double raiz(Funcion f, double x0, double x1, int n, double error){
        double r = Double.NaN;
        double x = x0;
        int k = 0;
        String i = "x0 \tx1 \tx \tf(x)";
        iter.add(i);

        while(Math.abs(f.evaluacion(x)) > error && k < n){
            x = ((x0 * f.evaluacion(x1)) - (x1 * f.evaluacion(x0)))/(f.evaluacion(x1)-f.evaluacion(x0));
            i = "\n" + x0 + "\t" + x1 + "\t" + x + "\t" + f.evaluacion(x);
            iter.add(i);
            if(f.evaluacion(x0)*f.evaluacion(x) < 0)
                x1 = x;
            else
                x0 = x;
            k++;
        }
        if(k<n)r=x;
        return r;
             
    }

    public ArrayList<String> getIter(){
        return iter;
    }
}