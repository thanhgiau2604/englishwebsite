package myweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.Question;
import myweb.entity.Study;
import myweb.entity.Video;

public interface StudyRepository extends CrudRepository<Study, String>{
	//Cập nhật pass=1
	@Modifying
	@Transactional
	@Query("Update Study stu SET stu.pass=1 where stu.username=:username and stu.topic=:topic and stu.level=:level")
	void UpdatePass(@Param("username") String username, @Param("topic") String topic, @Param("level") int level);
	
	//Update số câu đúng
	@Modifying
	@Transactional
	@Query("Update Study stu SET stu.correct=stu.correct+1 where stu.username=:username and "
			+ "stu.topic=:topic and stu.level=:level")
	void UpdateCorrect(@Param("username") String username, @Param("topic") String topic, @Param("level") int level);
	
	//Insert vào bảng
	@Modifying
	@Transactional
	@Query(value = "Insert INTO Study (username,topic,level,correct,pass) "
			+ "VALUES(:username,:topic,:level,:correct,1)", nativeQuery=true)
	void InsertProcess(@Param("username") String username, @Param("topic") String topic, @Param("level") int level,
			@Param("correct") int correct);
	
	//Reset topic
	@Modifying
	@Transactional
	@Query("Delete Study stu where stu.username=:username and stu.topic=:topic")
	void ResetTopic(@Param("username") String username, @Param("topic") String topic);
	
	//Lấy danh sách câu hỏi của chủ đề ở level ?
	@Query("Select qu from Question qu where qu.topic=:topic and qu.levelquestion=:level")
	List<Question> SelectGroupQuestion(@Param("topic") String topic, @Param("level") int level);
	
	//Kiểm tra đáp án có khớp không
	@Query("Select qu from Question qu where qu.idquestion=:idquestion and qu.keyquestion=:keyquestion")
	Question CheckAnswer(@Param("idquestion") String idquestion, @Param("keyquestion") String keyquestion);
	
	//Lấy số dòng của topic (số level)
	@Query("Select count(*) from Study stu where stu.username=:username and stu.topic=:topic")
	int GetLevel(@Param("username") String username, @Param("topic") String topic);
	
	//Kiểm tra vượt qua level chưa
	@Query("Select count(*) from Study stu where stu.username=:username and stu.topic=:topic and stu.level=:level and stu.pass=1")
	int CheckPassLevel(@Param("username") String username, @Param("topic") String topic, @Param("level") String level);
	
	//Lấy điểm số của level
	@Query("Select stu.correct from Study stu where stu.username=:username and stu.topic=:topic and stu.level=:level")
	int GetCorrect(@Param("username") String username, @Param("topic") String topic, @Param("level") String level);
	
	//Lấy ds video
	@Query("Select vid from Video vid where vid.topic=:topic")
	List<Video> SelectListVideo(@Param("topic") String topic);
}
