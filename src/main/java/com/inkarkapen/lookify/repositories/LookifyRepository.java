package com.inkarkapen.lookify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.inkarkapen.lookify.models.Song;

public interface LookifyRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByArtist(String artist);
	List<Song> findTop10ByOrderByRatingDesc();
}
