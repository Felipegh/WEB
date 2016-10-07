//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

public class FormataData {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
		
		//Date dataagora = new Date();
		//System.out.println(formatoBrasileiro.format(dataagora));
		
			String meuniver = "11/04/1983";
		
			Date meuniverDate = formatoBrasileiro.parse(meuniver);
			System.out.println(meuniverDate);
		
		
		
	}
		
	
}
