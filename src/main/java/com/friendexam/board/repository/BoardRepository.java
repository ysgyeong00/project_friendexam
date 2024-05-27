package com.friendexam.board.repository;

import com.friendexam.board.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}