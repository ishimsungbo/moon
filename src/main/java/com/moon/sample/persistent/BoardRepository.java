package com.moon.sample.persistent;


import com.moon.sample.vo.Board;
import org.springframework.data.repository.CrudRepository;


public interface BoardRepository extends CrudRepository<Board, Long> {


}
