package myweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, String>{
	@Modifying
	@Transactional
	@Query("Update Video vi SET vi.url=:url, vi.level=:level, vi.topic=:topic where vi.idvideo=:idvideo")
	void UpdateVideo(@Param("url") String url, @Param("level") String level, @Param("topic") String topic,
			@Param("idvideo") String idvideo);
	
	@Modifying
	@Transactional
	@Query(value = "Insert INTO Video (idvideo,url,level,topic) "
			+ "VALUES(:idvideo,:url,:level,:topic)", nativeQuery=true)
	void AddVideo(@Param("url") String url, @Param("level") String level, @Param("topic") String topic,
			@Param("idvideo") String idvideo);
	
	@Modifying
	@Transactional
	@Query("Delete Video vi where vi.idvideo=:idvideo")
	void DeleteVideo(@Param("idvideo") String idvideo);
}
