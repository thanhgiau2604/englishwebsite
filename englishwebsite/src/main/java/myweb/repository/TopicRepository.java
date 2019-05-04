package myweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.Topic;
@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
	@Modifying
	@Transactional
	@Query("Update Topic to SET to.nametopic=:name, to.describetopic=:describe where to.idtopic=:idtopic")
	void UpdateTopic(@Param("name") String name, @Param("describe") String describe, @Param("idtopic") String idtopic);
	
	@Modifying
	@Transactional
	@Query(value = "Insert INTO Topic (idtopic,nametopic,describetopic) "
			+ "VALUES(:idtopic,:name,:describe)", nativeQuery=true)
	void AddTopic(@Param("idtopic") String idtopic, @Param("name") String name, @Param("describe") String describe);
	
	@Modifying
	@Transactional
	@Query("Delete Topic to where to.idtopic=:idtopic")
	void DeleteTopic(@Param("idtopic") String idtopic);
}
