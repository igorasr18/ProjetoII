
public class MainMySQL {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MySQLAccess dao = new MySQLAccess();
		dao.createTable();
		long tempoInicio, tempoFinal, tempoInsert, tempoSelectAll, tempoSelectJoin, tempoSelect1Item, tempoSelect1ItemJoin;
		
		//Salvando tempos de execução
		tempoInicio = System.currentTimeMillis();
    	dao.povoandoBanco();
    	tempoFinal = System.currentTimeMillis();
    	tempoInsert = tempoFinal - tempoInicio;
    	
    	
		tempoInicio = System.currentTimeMillis();
    	dao.readDataBase();
		tempoFinal = System.currentTimeMillis();
		tempoSelectAll = tempoFinal - tempoInicio;
		
		tempoInicio = System.currentTimeMillis();
    	dao.selectJoin();
		tempoFinal = System.currentTimeMillis();
		tempoSelectJoin = tempoFinal - tempoInicio;
		
		tempoInicio = System.currentTimeMillis();
    	dao.select1Item("99926");
		tempoFinal = System.currentTimeMillis();
		tempoSelect1Item = tempoFinal - tempoInicio;
		
		tempoInicio = System.currentTimeMillis();
    	dao.select1ItemJoin("99926");;
		tempoFinal = System.currentTimeMillis();
		tempoSelect1ItemJoin = tempoFinal - tempoInicio;
		
		
		//Imprimindo resultados
		System.out.println();
		System.out.println(String.format("Tempo de insert no Banco: %02d segundos  e %02d milisegundos", tempoInsert/1000, tempoInsert%1000));
		System.out.println(String.format("Tempo de select no Banco: %02d segundos  e %02d milisegundos", tempoSelectAll/1000, tempoSelectAll%1000));
		System.out.println(String.format("Tempo de select com join no Banco: %02d segundos  e %02d milisegundos", tempoSelectJoin/1000, tempoSelectJoin%1000));
		System.out.println(String.format("Tempo de select 1 item no Banco: %02d segundos  e %02d milisegundos", tempoSelect1Item/1000, tempoSelect1Item%1000));
		System.out.println(String.format("Tempo de select 1 item com join no Banco: %02d segundos  e %02d milisegundos", tempoSelect1ItemJoin/1000, tempoSelect1ItemJoin%1000));
	}

}
