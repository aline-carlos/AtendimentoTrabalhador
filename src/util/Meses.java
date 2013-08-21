package util;

import java.util.HashMap;
import java.util.Map;


public class Meses {
	
	public static final Map<Integer, String> meses = new HashMap<Integer, String>();
	public static final Map<Integer, String> mesesabrev = new HashMap<Integer, String>();
	
    static {
    	meses.put(1, "Janeiro");
    	meses.put(2, "Fevereiro");
    	meses.put(3, "Março");
    	meses.put(4, "Abril");
    	meses.put(5, "Maio");
    	meses.put(6, "Junho");
    	meses.put(7, "Julho");
    	meses.put(8, "Agosto");
    	meses.put(9, "Setembro");
    	meses.put(10, "Outubro");
    	meses.put(11, "Novembro");
    	meses.put(12, "Dezembro");
    	
    	mesesabrev.put(1, "Jan");
    	mesesabrev.put(2, "Fev");
    	mesesabrev.put(3, "Mar");
    	mesesabrev.put(4, "Abr");
    	mesesabrev.put(5, "Mai");
    	mesesabrev.put(6, "Jun");
    	mesesabrev.put(7, "Jul");
    	mesesabrev.put(8, "Ago");
    	mesesabrev.put(9, "Set");
    	mesesabrev.put(10, "Out");
    	mesesabrev.put(11, "Nov");
    	mesesabrev.put(12, "Dez");
    }


}
