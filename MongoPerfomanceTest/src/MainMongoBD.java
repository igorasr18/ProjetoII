
public class MainMongoBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tempoInicio, tempoFinal, tempoInsert, tempoFindAll, tempoFind1Item;
		ConnectionMongoDb dao = new ConnectionMongoDb();
		
		//Salvando tempos de execução
		tempoInicio = System.currentTimeMillis();
		dao.readfromfile();
		tempoFinal = System.currentTimeMillis();
		tempoInsert = tempoFinal - tempoInicio;
		
		tempoInicio = System.currentTimeMillis();
		dao.findAll();
		tempoFinal = System.currentTimeMillis();
		tempoFindAll = tempoFinal - tempoInicio;
		
		tempoInicio = System.currentTimeMillis();
		dao.select1Item("_id", "99926");
		tempoFinal = System.currentTimeMillis();
		tempoFind1Item = tempoFinal - tempoInicio;
		
		//Imprimindo resultados
		System.out.println();
		System.out.println(String.format("Tempo de insert no Banco: %02d segundos  e %02d milisegundos", tempoInsert/1000, tempoInsert%1000));
		System.out.println(String.format("Tempo de find no Banco: %02d segundos  e %02d milisegundos", tempoFindAll/1000, tempoFindAll%1000));
		System.out.println(String.format("Tempo de find 1 item no Banco: %02d segundos  e %02d milisegundos", tempoFind1Item/1000, tempoFind1Item%1000));
	}

}
