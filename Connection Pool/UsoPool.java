package sql;

public class UsoPool {
	
	public static void main(String[] args) {
		
		PoolManager poolManager = new PoolManager();
		UsoSql[] usoSql = new UsoSql[300];
		for (int i = 0; i < usoSql.length; i++) {
			usoSql[i] = new UsoSql(poolManager);
		    usoSql[i].start();
		}
    }
}
