package br.com.flexvision.befd.flex4.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.flexvision.befd.flex4.dto.SubItem;
import br.com.flexvision.befd.flex4.dto.TypeOrigin;

@Repository
public class SiteDAO extends BaseFlex4DAO{
	
	public List<SubItem> getListByFilter(int met_id, int ndt_id){
		StringBuilder baseSql = new StringBuilder("");
		
		baseSql.append("select site.sit_id, site.name");
		baseSql.append(" from model_metric_formula mmf");
		baseSql.append(" inner join model_metric mm on mm.mmt_id=mmf.mmt_id");
		baseSql.append(" inner join model model on model.mod_id=mm.mod_id");
		baseSql.append(" inner join metric m on m.met_id=mm.met_id");
		baseSql.append(" inner join model_list mml on mml.mod_id=mm.mod_id");
		baseSql.append(" inner join node n on n.mol_id=mml.mol_id");
		baseSql.append(" inner join nodetype ndt on ndt.ndt_id=model.ndt_id");
		baseSql.append(" inner join site site on site.sit_id=n.sit_id");
		baseSql.append(" where ndt.ndt_id=:ndt_id and m.met_id=:met_id");
		baseSql.append(" group by site.sit_id, site.name");
		
		Query query = entityManager.createNativeQuery(baseSql.toString());
		query.setParameter("ndt_id", ndt_id);
		query.setParameter("met_id", met_id);

		List<Object[]> results = query.getResultList();
		
		List<SubItem> listSites =  new ArrayList<SubItem>();
		results.stream().forEach((record) -> {
			SubItem s = new SubItem();
	        int i=0;
	        s.setIdOri((Integer) record[i++]);
	        s.setName((String) record[i++]);
	        s.setOrigin(TypeOrigin.SITE);
	        listSites.add(s);
		});

		return listSites;
		
	}
	
}
