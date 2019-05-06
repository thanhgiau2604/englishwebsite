package myweb.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question, String>{
	@Modifying
	@Transactional
	@Query("Update Question qu SET qu.content=:content, qu.optiona=:optiona, qu.optionb=:optionb, qu.optionc=:optionc, qu.optiond=:optiond,"
			+ "qu.keyquestion=:keyquestion, qu.explainkey=:explainkey,qu.levelquestion=:levelquestion, qu.topic=:topic where qu.idquestion=:idquestion")
	void UpdateQuestion(@Param("content") String content, @Param("optiona") String optiona, @Param("optionb") String optionb,
			@Param("optionc") String optionc, @Param("optiond") String optiond,@Param("keyquestion") String keyquestion, @Param("explainkey") String explainkey,
			@Param("levelquestion") int levelquestion, @Param("topic") String topic, @Param("idquestion") String idquestion);
	
	@Modifying
	@Transactional
	@Query(value = "Insert INTO Question (idquestion,content,optiona,optionb,optionc,optiond,keyquestion,explainkey,levelquestion,topic) "
			+ "VALUES(:idquestion,:content,:optiona,:optionb,:optionc,:optiond,:keyquestion,:explainkey,:levelquestion,:topic)", nativeQuery=true)
	void AddQuestion(@Param("idquestion") String idquestion, @Param("content") String content, @Param("optiona") String optiona, 
			@Param("optionb") String optionb, @Param("optionc") String optionc, @Param("optiond") String optiond,
			@Param("keyquestion") String keyquestion, @Param("explainkey") String explainkey, @Param("levelquestion") int levelquestion, @Param("topic") String topic);
	
	@Modifying
	@Transactional
	@Query("Delete Question qu where qu.idquestion=:idquestion")
	void DeleteQuestion(@Param("idquestion") String idquestion);
}
