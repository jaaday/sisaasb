package br.ufrn.cerescaico.bsi.sisaasb.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("sisaasbPU");
}
